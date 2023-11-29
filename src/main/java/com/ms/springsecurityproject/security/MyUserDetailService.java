package com.ms.springsecurityproject.security;

import com.ms.springsecurityproject.entity.User;
import com.ms.springsecurityproject.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class MyUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> findUser = userRepository.findByUsername(username);
        User user = new User();
        if(findUser.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserDetail(user.getUsername(), user.getPassword());
    }
}
