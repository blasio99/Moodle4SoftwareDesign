package dev.blasio99.moodle.server.api.assembler;

import org.springframework.stereotype.Component;

import dev.blasio99.moodle.common.dto.UserRegisterDTO;
import dev.blasio99.moodle.server.enums.GroupName;
import dev.blasio99.moodle.server.enums.Role;
import dev.blasio99.moodle.server.model.User;

@Component
public class UserRegisterAssembler implements BaseAssembler<UserRegisterDTO, User> {
    
    @Override
    public User createModel(UserRegisterDTO dto) {
        User user = new User();
		user.setId(dto.getId());
		user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setGroupName(GroupName.valueOf(dto.getGroupName()));
		user.setHobby(dto.getHobby());
        user.setRole(Role.valueOf(dto.getRole()));
        return user;
    }

    @Override
    public UserRegisterDTO createDTO(User model) {
        UserRegisterDTO dto = new UserRegisterDTO();
        dto.setId(model.getId());
		dto.setEmail(model.getEmail());
        dto.setUsername(model.getUsername());
        dto.setPassword(model.getPassword());
		dto.setGroupName(model.getGroupName().name());
		dto.setHobby(model.getHobby());
        dto.setRole(model.getRole().name());
        return dto;
    }
}