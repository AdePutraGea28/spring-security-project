package com.ms.springsecurityproject.service;

import com.ms.springsecurityproject.entity.User;
import com.ms.springsecurityproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // create
    public String create(User user) {
        String result;
        try {
            User newUser = new User();
            newUser.setUsername(user.getUsername());
            newUser.setPassword(user.getPassword());
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
        Optional<User> findUser = userRepository.findByUsername(username);
        if(!findUser.isEmpty()) {
            user = findUser.get();
        }
        return user;
    }

    // update

    // delete
}
