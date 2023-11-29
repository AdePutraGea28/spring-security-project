package com.ms.springsecurityproject.service;

import com.ms.springsecurityproject.entity.User;
import com.ms.springsecurityproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // create
    public String create(User user) {
        String result;
        try {
            User newUser = new User();
            newUser.setUsername(user.getUsername());
            newUser.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(newUser);
            result = "Success";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            result = "Failed";
        }

        return result;

    }

    // findAll
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    // findByUsername
    public User findByUsername(String username) {
        User user = new User();
        User findUser = userRepository.findByUsername(username);
        if(findUser != null) {
            user = findUser;
        }
        return user;
    }

    // update

    // delete
}
