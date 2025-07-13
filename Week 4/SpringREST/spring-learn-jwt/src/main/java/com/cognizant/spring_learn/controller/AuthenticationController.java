package com.cognizant.spring_learn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

import static com.cognizant.spring_learn.SpringLearnApplication.LOGGER;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START - /authenticate");
        LOGGER.debug("Authorization header: {}", authHeader);


        String user = getUser(authHeader);
        LOGGER.debug("Decoded user: {}", user);


        String token = generateJwt(user);


        Map<String, String> map = new HashMap<>();
        map.put("token", token);

        LOGGER.info("END - /authenticate");
        return map;
    }


    private String getUser(String authHeader) {
        String encodedCredentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decodedString = new String(decodedBytes);
        return decodedString.split(":")[0];
    }

    private String generateJwt(String user) {
        SecretKey key = Keys.hmacShaKeyFor("Z3f8N1qP9sVbX7KwLcEjR5uY0oTmQ2iAvHpWgB6zXrFyUjCd".getBytes());

        JwtBuilder builder = Jwts.builder()
                .setSubject(user)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1200000)) // 20 min
                .signWith(key, SignatureAlgorithm.HS256);

        return builder.compact();
    }

}
