package com.example.demo.dto;

import com.example.demo.services.validation.UserInsertValid;

import lombok.Data;

@Data
@UserInsertValid
public class UserInsertDTO extends UserDTO {
    private String password;
}
