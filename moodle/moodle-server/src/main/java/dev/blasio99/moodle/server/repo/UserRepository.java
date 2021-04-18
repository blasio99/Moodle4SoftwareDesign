package dev.blasio99.moodle.server.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dev.blasio99.moodle.server.enums.GroupName;
import dev.blasio99.moodle.server.enums.Role;
import dev.blasio99.moodle.server.model.User;

public interface UserRepository extends CrudRepository<User, Long>  {
    public User findByUsername(String username);
	public User findByEmail(String email);
    public List<User> findByRole(Role role);
	public List<User> findByGroupName(GroupName groupName);
}