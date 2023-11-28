package com.ms.springsecurityproject.repository;

import com.ms.springsecurityproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
