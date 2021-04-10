package dev.blasio99.moodle.server.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dev.blasio99.moodle.server.enums.Roles;
import dev.blasio99.moodle.server.model.User;

public interface UserRepository extends CrudRepository<User, Long>  {
    public User findByUsername(String username);
    public List<User> findByRole(Roles role);
}