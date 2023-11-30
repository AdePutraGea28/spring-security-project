package com.ms.springsecurityproject.dto;

import lombok.Data;

@Data
public class UserResponseLogin {
    private String username;
    private String token;
}
