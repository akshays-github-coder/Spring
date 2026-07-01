package com.cwa.lms.user_service.service;

import com.cwa.lms.user_service.config.JwtUtil;
import com.cwa.lms.user_service.dto.LoginRequest;
import com.cwa.lms.user_service.dto.RegisterRequest;
import com.cwa.lms.user_service.entity.User;
import com.cwa.lms.user_service.exception.UserAlreadyExistsException;
import com.cwa.lms.user_service.exception.UserNotFoundException;
import com.cwa.lms.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public String register(RegisterRequest request) {
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("User already exists with email: " + request.getEmail());
        }

        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setMobile(request.getMobile());
        user.setPassword(
                passwordEncoder.encode(
                    request.getPassword()));

        user.setRole("CUSTOMER");

        userRepository.save(user);

        return "User registered successfully";
    }

    public String login(LoginRequest loginRequest) {

        User user = userRepository.findByEmail(
                loginRequest.getUsername())
                        .orElseThrow(
                                () -> new UserNotFoundException("User " + loginRequest.getUsername() + " not found")
                        );

        if (!passwordEncoder.matches(
                loginRequest.getPassword(),
                user.getPassword()
        )
        ) {
            return "Wrong password";
        }

//        return JWT token when logged in successfully
        return jwtUtil.generateToken(user);
    }

    public Optional<User> getUserProfile(Long id) {
        return Optional.of(userRepository.findById(id).
                orElseThrow(
                        () -> new UserNotFoundException("User " + id + " not found")));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "User " + email + " not found"
                        ));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                List.of(
                        new SimpleGrantedAuthority("ROLE_USER")
                )
        );
    }
}
