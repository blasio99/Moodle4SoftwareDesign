package dev.blasio99.moodle.server.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dev.blasio99.moodle.server.model.Submission;

public interface SubmissionRepository extends CrudRepository<Submission, Long> {
	public List<Submission> findByAssignmentId(Long assignmentId);
	public Submission findByUserId(Long userId);
}