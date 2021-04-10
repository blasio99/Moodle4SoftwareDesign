package dev.blasio99.moodle.server.api.assembler;

import org.springframework.stereotype.Component;

import dev.blasio99.moodle.common.dto.UserDTO;
import dev.blasio99.moodle.server.enums.Roles;
import dev.blasio99.moodle.server.model.User;

@Component
public class UserAssembler implements BaseAssembler<UserDTO, User> {

    @Override
    public User createModel(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setRole(Roles.valueOf(dto.getRole()));
        return user;
    }

    @Override
    public UserDTO createDTO(User model) {
        UserDTO dto = new UserDTO();
        dto.setId(model.getId());
        dto.setUsername(model.getUsername());
        dto.setRole(model.getRole().name());
        return dto;
    }
}