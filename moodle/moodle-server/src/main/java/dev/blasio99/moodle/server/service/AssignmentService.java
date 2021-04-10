package dev.blasio99.moodle.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.blasio99.moodle.server.model.Assignment;
import dev.blasio99.moodle.server.repo.AssignmentRepository;

@Service
public class AssignmentService {
    
    @Autowired
    private AssignmentRepository assignmentRepository;

	public List<Assignment> getAssignmentByLabNumber(Integer number) {
        return assignmentRepository.findByLaboratoryNumber(number);
    }

	public List<Assignment> getAllAssignments() {
        Iterable<Assignment> iterable = assignmentRepository.findAll();
        List<Assignment> assignments = new ArrayList<>();
        for (Assignment it : iterable) {
            assignments.add(it);
        }
        return assignments;
    }

	public Assignment addAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

	public Assignment updateAssignment(Assignment assignment) throws ServiceException {
        Assignment assign = assignmentRepository.findByName(assignment.getName());
        //check if an assignment with the new name does not exist
        if (assign != null && !(assign.getId().equals(assignment.getId()))) throw new ServiceException("Assignment name already exists!", HttpStatus.CONFLICT);
        return assignmentRepository.save(assignment);
    }

    public void deleteAssignment(String name) {
        Assignment assignment = assignmentRepository.findByName(name);
        if (assignment == null) return;
        assignmentRepository.delete(assignment);
    }

}
