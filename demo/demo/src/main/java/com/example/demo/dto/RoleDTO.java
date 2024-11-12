package com.example.demo.dto;
import java.io.Serializable;

import com.example.demo.entities.Role;

import lombok.Data;

@Data 
public class RoleDTO implements Serializable{
    private static final long serialVersionUID= 1L;
    private Long id;
    private String authority;

    public RoleDTO(){}

    public RoleDTO(Role role){
        super();
        id = role.getId();
        authority = role.getAuthority();
    }
}
