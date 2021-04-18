package dev.blasio99.moodle.server.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.blasio99.moodle.server.model.Submission;

@Repository
public interface SubmissionRepository extends CrudRepository<Submission, Long> {
	public List<Submission> findByAssignmentId(Long assignmentId);
	public List<Submission> findByUserId(Long userId);
	public Submission findBySubmissionId(Long submissionId);
}