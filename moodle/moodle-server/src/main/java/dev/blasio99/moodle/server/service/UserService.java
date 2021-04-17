package dev.blasio99.moodle.server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.blasio99.moodle.server.enums.Roles;
import dev.blasio99.moodle.server.exception.ServiceException;
import dev.blasio99.moodle.server.model.User;
import dev.blasio99.moodle.server.repo.UserRepository;

@Service
public class UserService {
    
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    @Autowired 
    private ValidationService validator;

    public User registerUser(User user, Roles role) throws ServiceException {
		
		System.out.println("-------------- " + user.getEmail());
		if (!validator.validateEmail(user.getEmail())) 
			throw new ServiceException("Invalid email address!", HttpStatus.UNPROCESSABLE_ENTITY);
        if (!validator.validateUsername(user.getUsername())) 
			throw new ServiceException("Invalid username!", HttpStatus.UNPROCESSABLE_ENTITY);
        if (!validator.validatePassword(user.getPassword())) 
			throw new ServiceException("Invalid password!", HttpStatus.UNPROCESSABLE_ENTITY);

        User u = userRepository.findByUsername(user.getUsername());
        if (u != null) throw new ServiceException("Username already taken!", HttpStatus.CONFLICT);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(role);

        return userRepository.save(user);
    }

	public User login(User user) throws ServiceException {

		try{
			User userFromRepository = userRepository.findByUsername(user.getUsername());
        	if(!passwordEncoder.matches(user.getPassword(), userFromRepository.getPassword())) 
				throw new ServiceException("Authorization failed!", HttpStatus.UNPROCESSABLE_ENTITY);
        	return userFromRepository;
		}
		catch(ServiceException e){
			throw new ServiceException("Resource not found!", HttpStatus.UNPROCESSABLE_ENTITY);
		}
        
    }

	public boolean checkIfUserExist(String email) {
        return userRepository.findByEmail(email)!=null ? true : false;
    }

    public List<User> getStudents() {
        return userRepository.findByRole(Roles.STUDENT);
    }

    public User getUserByUsername(String username) throws ServiceException {
        User user =  userRepository.findByUsername(username);
        if (user == null) throw new ServiceException("User not found", HttpStatus.NOT_FOUND);
        return user;
    }

	public User getUserByEmail(String email) throws ServiceException {
        User user =  userRepository.findByEmail(email);
        return user;
    }



	public Optional<User> getUserById(Long id) throws ServiceException {
        Optional<User> user =  userRepository.findById(id);
        if (user == null) throw new ServiceException("User not found", HttpStatus.NOT_FOUND);
        return user;
    }

	public User registerStudent(User user) throws ServiceException {
        return registerUser(user, Roles.STUDENT);
    }

    public User registerTeacher(User user) throws ServiceException {
        return registerUser(user, Roles.TEACHER);
    }

	public User updateUser(User user) throws ServiceException {
        User u = userRepository.findByEmail(user.getEmail());
        //check if username is available
        if (u != null && !(u.getId().equals(user.getId()))) throw new ServiceException("Username is taken!", HttpStatus.CONFLICT);
        return userRepository.save(user);
    }

    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) return;
        userRepository.delete(user);
    }

}