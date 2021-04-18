package dev.blasio99.moodle.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import dev.blasio99.moodle.server.exception.ServiceException;
import dev.blasio99.moodle.server.model.Submission;
import dev.blasio99.moodle.server.repo.SubmissionRepository;
import dev.blasio99.moodle.server.repo.UserRepository;

@Service
public class SubmissionService {
    
    @Autowired
    private UserRepository userRepository;

	@Autowired
    private SubmissionRepository submissionRepository;

	public List<Submission> getSubmissionByUserId(Long id) {
        return submissionRepository.findByUserId(id);
    }

	public List<Submission> getAllSubmissions() {
        Iterable<Submission> iterable = submissionRepository.findAll();
        List<Submission> submissions = new ArrayList<>();
        for (Submission it : iterable) {
            submissions.add(it);
        }
        return submissions;
    }

	public Submission submitAssignment(Submission submission, Authentication authentication) {
		submission.setUserId(userRepository.findByUsername(authentication.getName()).getId());
		submission.setGrade(-1);
        return submissionRepository.save(submission);
    }

	public Submission gradeAssignment(Long submissionId, Double grade) throws ServiceException {
        Submission submission = submissionRepository.findBySubmissionId(submissionId);
        if (submission == null) throw new ServiceException("Assignment submission does not exist!", HttpStatus.CONFLICT);
        
		submission.setGrade(grade);
		return submissionRepository.save(submission);
    }
}
