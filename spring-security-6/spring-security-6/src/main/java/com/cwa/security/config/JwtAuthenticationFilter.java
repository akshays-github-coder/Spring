package com.cwa.security.config;

import com.cwa.security.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/*
 * This filter executes once for every incoming HTTP request.
 *
 * Responsibilities:
 * 1. Read JWT token from Authorization header.
 * 2. Validate the token.
 * 3. Load user details from database/service.
 * 4. Create Authentication object.
 * 5. Store Authentication in SecurityContext.
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtService jwtService,
                                   UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        /*
         * Read Authorization header.
         *
         * Example:
         * Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
         */
        final String authHeader =
                request.getHeader("Authorization");

        /*
         * If Authorization header is missing
         * OR token doesn't start with Bearer,
         * skip authentication and continue.
         */
        if (authHeader == null ||
                !authHeader.startsWith("Bearer ")) {

            filterChain.doFilter(request, response);
            return; // Important
        }

        /*
         * Remove "Bearer " prefix.
         *
         * Example:
         * Bearer abc.xyz.pqr
         *
         * JWT becomes:
         * abc.xyz.pqr
         */
        final String jwt = authHeader.substring(7);

        /*
         * Extract username from JWT payload.
         */
        final String userName =
                jwtService.extractUserName(jwt);

        /*
         * Check if user is already authenticated.
         *
         * If authentication exists,
         * no need to authenticate again.
         */
        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        /*
         * Proceed only when:
         * 1. Username exists in token.
         * 2. User is not already authenticated.
         */
        if (userName != null && authentication == null) {

            /*
             * Load user details from database.
             *
             * Typically fetches:
             * - username
             * - password
             * - roles
             */
            UserDetails userDetails =
                    userDetailsService
                            .loadUserByUsername(userName);

            /*
             * Validate token:
             * - signature
             * - expiration
             * - username match
             */
            if (jwtService.isTokenValid(jwt, userDetails)) {

                /*
                 * Create Authentication object.
                 *
                 * Principal = UserDetails
                 * Credentials = null
                 * Authorities = User Roles
                 */
                UsernamePasswordAuthenticationToken
                        authenticationToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                /*
                 * Add request-specific details.
                 *
                 * Example:
                 * - IP Address
                 * - Session Id
                 */
                authenticationToken.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request)
                );

                /*
                 * VERY IMPORTANT STEP
                 *
                 * Store Authentication object in
                 * Spring Security Context.
                 *
                 * Without this line,
                 * user will NOT be authenticated.
                 */
                SecurityContextHolder
                        .getContext()
                        .setAuthentication(authenticationToken);
            }
        }

        /*
         * Continue processing next filter.
         */
        filterChain.doFilter(request, response);
    }
}