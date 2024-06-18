package com.klayvert.vendas.rest.dtos;

import com.klayvert.vendas.domain.entities.User;
import com.klayvert.vendas.domain.entities.UserAuthenticated;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Long id;

    private String username;

    private String password;

    private String role;

    public static UserDTO toDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole()
        );
    }

    public static User toOBJ(UserDTO dto) {
        return new User(
                dto.getId(),
                dto.getUsername(),
                dto.getPassword(),
                dto.getRole()
        );
    }
}
