package dev.blasio99.moodle.server.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.blasio99.moodle.common.dto.SubmissionDTO;
import dev.blasio99.moodle.server.api.assembler.SubmissionAssembler;
import dev.blasio99.moodle.server.model.Submission;
import dev.blasio99.moodle.server.exception.ServiceException;
import dev.blasio99.moodle.server.service.SubmissionService;


@CrossOrigin("*")
@RestController
public class SubmissionResource {
	@Autowired
    private SubmissionService submissionService;

    @Autowired
    private SubmissionAssembler submissionAssembler;

	
    @GetMapping("api/assignment/submission/{userId}")
    public ResponseEntity<List<SubmissionDTO>> getAssignmentByName(@PathVariable Long userId) {
        try {
            List<SubmissionDTO> assignment = submissionAssembler.createDTOList(submissionService.getSubmissionByUserId(userId));
            return new ResponseEntity<>(assignment, HttpStatus.OK);
        }
        catch(ServiceException e) {
            return new ResponseEntity<>(e.getHttpStatus());
        }
 
    }

	@GetMapping("teacher/api/assignment/submissions/all")
	public List<SubmissionDTO> getSubmissions() {
		return submissionAssembler.createDTOList(submissionService.getAllSubmissions());
    }

	@PostMapping("api/assignment/submit")
	@ResponseStatus(HttpStatus.CREATED)
	public Submission submitAssignment(@RequestBody SubmissionDTO dto){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return submissionService.submitAssignment(submissionAssembler.createModel(dto), authentication);
	}

	@PostMapping("teacher/api/assignment/grade")
	@ResponseStatus(HttpStatus.CREATED)
	public Submission gradeAssignment(@RequestParam Long submissionId, @RequestParam Double grade){
		return submissionService.gradeAssignment(submissionId, grade);
	}
}
