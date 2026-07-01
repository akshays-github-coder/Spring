package com.cwa.lms.user_service.config;

import com.cwa.lms.user_service.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtUtil {
    public String generateToken(User user) {

        return Jwts
                .builder()
                .subject(user.getEmail())
                .claim("role", user.getRole())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 60 * 10 * 1000))
                .signWith(generateSecretKey())
                .compact();
    }

    private SecretKey generateSecretKey() {

        // Decodes Base64 encoded secret key String into byte array
        byte[] decode = Decoders.BASE64.decode(getSecretKey());

        // Creates HMAC SHA secret key using decoded bytes
        // Used internally for JWT signature generation & validation
        return Keys.hmacShaKeyFor(decode);
    }

    // Returns secret key used for JWT signing
    public String getSecretKey() {

        // Secret key should ideally come from: 1. application.properties or 2. environment variables 3. vault/secret manager
        // Hardcoding secret key is not recommended for production
        return "4bffe96bed8de287478b198e6f710068fc9257cc590d14ff18159ee6fda22307";
    }
}
