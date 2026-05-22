package com.cwa.security.service;

import com.cwa.security.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    // Generates JWT token for authenticated user
    public String generateToken(User user) {

        // Stores additional custom claims for JWT payload
        // Example:
        // claims.put("role", "ADMIN");
        // claims.put("email", user.getEmail());
        Map<String, Object> claims = new HashMap<>();

        return Jwts
                // Starts JWT token creation
                .builder()

                // Adds custom claims section
                .claims()

                // Adds all claims from HashMap into JWT payload
                .add(claims)

                // Sets subject of JWT
                // Usually username or unique user identifier
                .subject(user.getUserName())

                // Sets token issuer/application name
                .issuer("CWA")

                // Sets token creation time
                .issuedAt(new Date(System.currentTimeMillis()))

                // Sets token expiration time
                // Current time + 10 minutes
                // Formula:
                // 60 seconds * 10 minutes * 1000 milliseconds
                .expiration(new Date(System.currentTimeMillis() + 60*10*1000))

                // Ends claims configuration block
                .and()

                // Signs JWT using secret key
                // Signature prevents token tampering
                .signWith(generateKey())

                // Converts JWT object into compact String format
                // Final output:
                // header.payload.signature
                .compact();
    }

    // Generates SecretKey used for signing and verifying JWT
    private SecretKey generateKey() {

        // Decodes Base64 encoded secret key String into byte array
        byte[] decode = Decoders.BASE64.decode(getSecretKey());

        // Creates HMAC SHA secret key using decoded bytes
        // Used internally for JWT signature generation & validation
        return Keys.hmacShaKeyFor(decode);
    }

    // Returns secret key used for JWT signing
    public String getSecretKey() {

        // Secret key should ideally come from:
        // application.properties
        // environment variables
        // vault/secret manager

        // Hardcoding secret key is not recommended for production
        return "4bffe96bed8de287478b198e6f710068fc9257cc590d14ff18159ee6fda22307";
    }

    // Extracts username (subject) from JWT token
    public String extractUserName(String token) {

        // Calls generic extractClaims method
        // Claims::getSubject extracts "sub" field from JWT payload
        return extractClaims(token, Claims::getSubject);
    }

    // Generic method to extract any claim from JWT
    private <T> T extractClaims(
            String token,
            Function<Claims, T> claimResolver) {

        // Extract all claims from JWT token
        Claims claims = extractClaims(token);

        // Applies lambda/function to extract specific claim
        // Example:
        // Claims::getSubject
        // Claims::getExpiration
        return claimResolver.apply(claims);
    }

    private Claims extractClaims(String token) {
        return Jwts
                // Creates JWT parser builder
                // Used to configure how JWT token should be validated
                .parser()

                // Verifies JWT signature using secret key
                // If signature is invalid, token parsing will fail
                // generateKey() returns SecretKey used for signing & validation
                .verifyWith(generateKey())

                // Builds the JWT parser object with configured settings
                .build()

                // Parses signed JWT token
                // Validates:
                // 1. Token signature
                // 2. Token structure
                // 3. Whether token is tampered
                .parseSignedClaims(token)

                // Extracts payload/body part of JWT
                // Payload contains claims like:
                // username, roles, expiration time, issued time etc.
                .getPayload();
    }

    // Validates whether JWT token is valid for given user
    public boolean isTokenValid(String token, UserDetails userDetails) {

        // Extract username from JWT token
        final String userName = extractUserName(token);

        // Token is valid only if:
        // 1. Username inside token matches logged-in user
        // 2. Token is not expired
        return (
                userName.equals(userDetails.getUsername())
                        &&
                        !isTokenExpired(token)
        );
    }

    // Checks whether JWT token has expired
    private boolean isTokenExpired(String token) {

        // extractExpiration(token) returns token expiry date
        // before(new Date()) means:
        // Is token expiry time before current time?
        // If yes -> token expired
        return extractExpiration(token).before(new Date());
    }

    // Extracts expiration date from JWT token
    private Date extractExpiration(String token) {

        // Claims::getExpiration extracts "exp" claim from JWT payload
        return extractClaims(token, Claims::getExpiration);
    }

}
