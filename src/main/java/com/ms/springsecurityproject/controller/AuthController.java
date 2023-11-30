package com.ms.springsecurityproject.controller;

import com.ms.springsecurityproject.dto.UserRequestLogin;
import com.ms.springsecurityproject.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequestLogin request) {
        return authService.login(request);
        //return ResponseEntity.ok().body(authService.login(request));
    }
}
