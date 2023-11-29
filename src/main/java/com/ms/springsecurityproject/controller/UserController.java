package com.ms.springsecurityproject.controller;

import com.ms.springsecurityproject.entity.User;
import com.ms.springsecurityproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.create(user));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> findByUsername(@PathVariable("username") String username){
        return ResponseEntity.ok().body(userService.findByUsername(username));
    }
}
