package com.ms.springsecurityproject.service;

import com.ms.springsecurityproject.dto.UserRequestLogin;
import com.ms.springsecurityproject.dto.UserResponseLogin;
import com.ms.springsecurityproject.entity.User;
import com.ms.springsecurityproject.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    // private JwtUtils jwtUtils;

    // login
    public ResponseEntity<?> login(UserRequestLogin request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
            String username = authentication.getName();
            long expirationTime = 60*60*1000;
            String token = JwtUtils.generateToken(username, expirationTime);

            UserResponseLogin responseLogin = new UserResponseLogin();
            responseLogin.setUsername(username);
            responseLogin.setToken(token);
            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION,token)
                    .body(responseLogin);
        } catch (Exception e) {
            System.out.println("Error : " + e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Failed");
        }
    }

    // logout

}
