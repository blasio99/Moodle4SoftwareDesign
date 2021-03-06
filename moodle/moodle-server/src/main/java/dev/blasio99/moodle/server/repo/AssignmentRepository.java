package dev.blasio99.moodle.server.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dev.blasio99.moodle.server.model.Assignment;

public interface AssignmentRepository extends CrudRepository<Assignment, Long> {
	public List<Assignment> findByLaboratoryNumber(Integer number);
	public Assignment findByName(String name);
}
