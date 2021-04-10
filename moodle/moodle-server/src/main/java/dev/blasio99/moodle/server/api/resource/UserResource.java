package dev.blasio99.moodle.server.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.blasio99.moodle.common.dto.UserDTO;
import dev.blasio99.moodle.common.dto.UserRegisterDTO;

import dev.blasio99.moodle.server.api.assembler.UserAssembler;
import dev.blasio99.moodle.server.api.assembler.UserRegisterAssembler;
import dev.blasio99.moodle.server.model.User;
import dev.blasio99.moodle.server.service.ServiceException;
import dev.blasio99.moodle.server.service.UserService;


@CrossOrigin("*")
@RestController
public class UserResource {

    @Autowired
    private UserAssembler userAssembler;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRegisterAssembler userRegisterAssembler;

	@PostMapping("/login")
    public UserDTO login(@RequestBody UserRegisterDTO dto) {
        return userAssembler.createDTO(userService.login(userRegisterAssembler.createModel(dto)));
    }

    @GetMapping("/teacher/api/user/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable("username") String username) {
        try {
            User user = userService.getUserByUsername(username);
            return new ResponseEntity<>(userAssembler.createDTO(user), HttpStatus.OK);
        } catch(ServiceException e) {
            return new ResponseEntity<>(e.getHttpStatus());
        }
    }

    @GetMapping("/teacher/api/students")
    public List<UserDTO> getStudents() {
        return userAssembler.createDTOList(userService.getStudents());
    }

    @PostMapping("/teacher/api/register/teacher")
	@ResponseStatus(HttpStatus.CREATED)
    public UserDTO registerTeacher(@RequestBody UserRegisterDTO dto) {
        User user = userService.registerTeacher(userRegisterAssembler.createModel(dto));
        return userAssembler.createDTO(user);
    }

	@PostMapping("/teacher/api/register/student")
	@ResponseStatus(HttpStatus.CREATED)
    public UserDTO registerStudent(@RequestBody UserRegisterDTO dto) {
            User user = userService.registerStudent(userRegisterAssembler.createModel(dto));
            return userAssembler.createDTO(user);
        
    }

    @DeleteMapping("/teacher/api/delete/user/{username}")
    public void deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
    }
    
}