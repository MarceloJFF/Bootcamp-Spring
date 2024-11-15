package com.example.demo.dto;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@EqualsAndHashCode
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements Serializable{
    private static final long serialVersionUID= 1L;
    private Long id;

    @NotBlank(message ="campo obrigatório")
    private String firstName;
    private String lastName;
    @Email(message = "favor entrar com um email válido")
    private String email;
    Set<RoleDTO> roles = new HashSet<>();

    public UserDTO(User entity){
        super();
        this.id = entity.getId();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.email = entity.getEmail();
        entity.getRoles().forEach(role->this.roles.add(new RoleDTO(role)));
    }

}
