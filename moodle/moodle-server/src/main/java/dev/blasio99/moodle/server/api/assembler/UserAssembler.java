package dev.blasio99.moodle.server.api.assembler;

import org.springframework.stereotype.Component;

import dev.blasio99.moodle.common.dto.UserDTO;
import dev.blasio99.moodle.server.enums.GroupName;
import dev.blasio99.moodle.server.enums.Role;
import dev.blasio99.moodle.server.model.User;

@Component
public class UserAssembler implements BaseAssembler<UserDTO, User> {

    @Override
    public User createModel(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
		user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
		user.setGroupName(GroupName.valueOf(dto.getGroupName()));
		user.setHobby(dto.getHobby());
        user.setRole(Role.valueOf(dto.getRole()));
        return user;
    }

    @Override
    public UserDTO createDTO(User model) {
        UserDTO dto = new UserDTO();
        dto.setId(model.getId());
		dto.setEmail(model.getEmail());
        dto.setUsername(model.getUsername());
		dto.setGroupName(model.getGroupName().name());
		dto.setHobby(model.getHobby());
        dto.setRole(model.getRole().name());
        return dto;
    }
}