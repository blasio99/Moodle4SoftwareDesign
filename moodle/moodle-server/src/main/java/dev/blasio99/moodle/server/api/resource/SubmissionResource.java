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
import org.springframework.web.bind.annotation.RestController;

import dev.blasio99.moodle.common.dto.AssignmentDTO;

import dev.blasio99.moodle.server.api.assembler.AssignmentAssembler;
import dev.blasio99.moodle.server.model.Assignment;
import dev.blasio99.moodle.server.exception.ServiceException;
import dev.blasio99.moodle.server.service.AssignmentService;


@CrossOrigin("*")
@RestController
public class SubmissionResource {
	/*@Autowired
    private AssignmentService assignmentService;

    @Autowired
    private AssignmentAssembler assignmentAssembler;

	
    @GetMapping("api/assignment/lab/{number}")
    public ResponseEntity<List<AssignmentDTO>> getAssignmentByName(@PathVariable Integer number) {
        try {
            List<AssignmentDTO> assignment = assignmentAssembler.createDTOList(assignmentService.getAssignmentByLabNumber(number));
            return new ResponseEntity<>(assignment, HttpStatus.OK);
        }
        catch(ServiceException e) {
            return new ResponseEntity<>(e.getHttpStatus());
        }
 
    }

    @PostMapping("teacher/api/assignment/add")
    public Assignment addAssignment(@RequestBody AssignmentDTO dto) {
        return assignmentService.addAssignment(assignmentAssembler.createModel(dto));
    }

	@GetMapping("api/assignment/all")
	public List<AssignmentDTO> getAssignments() {
		return assignmentAssembler.createDTOList(assignmentService.getAllAssignments());
    }

    @DeleteMapping("/teacher/api/assignment/delete/{name}")
    public void deleteAssignment(@PathVariable String name) {
        assignmentService.deleteAssignment(name);
    }*/
}
