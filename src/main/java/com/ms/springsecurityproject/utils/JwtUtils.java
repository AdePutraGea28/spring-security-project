package com.ms.springsecurityproject.utils;

import com.ms.springsecurityproject.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtils {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // generatedtoken
    public static String generateToken(String username, long expirationTime) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationTime);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key)
                .compact();
    }


















//    private final String secretKey = "mysecretkey";
//    private long accessTokenValidity = 60*60*1000;
//
//    private String tokeHeader = "Authorization";
//    private String tokenPrefix = "Bearer ";
//
//    private final JwtParser jwtParser;
//
//    public JwtUtils() {
//        this.jwtParser = Jwts.parser().setSigningKey(secretKey).build();
//    }

//    public String createToken(User user) {
//        Claims claims = Jwts.claims().setSubject(user.getUsername()).build();
//        claims.put("username", user.getUsername());
//        Date tokenCreateTime = new Date();
//        Date tokenValidity = new Date(tokenCreateTime.getTime() + TimeUnit.MINUTES.toMillis(accessTokenValidity));
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setExpiration(tokenValidity)
//                .signWith(SignatureAlgorithm.HS256, secretKey)
//                .compact();
//    }

}
