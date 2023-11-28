package com.ms.springsecurityproject.service;

import com.ms.springsecurityproject.entity.User;
import com.ms.springsecurityproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // create
    public String create(User user) {
        return "Success"
    }

    // findAll
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        return users;
    }

    // findByUsername
    public User findByUsername(String username) {
        return new User();
    }

    // update

    // delete
}
