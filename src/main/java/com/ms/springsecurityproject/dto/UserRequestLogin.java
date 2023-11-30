package com.ms.springsecurityproject.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class UserRequestLogin {
    private String username;
    private String password;
}
