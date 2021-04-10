package dev.blasio99.moodle.server.service;

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

    public List<Assignment> getAssignmentsForLab(Long laboratoryId) {
        return assignmentRepository.findByLaboratoryId(laboratoryId);
    }

    /*public Assignment addTicket(Assignment assignment) throws ServiceException {
        List<Assignment> assignments = getTicketsForConcert(assignment.getConcert().getId());
        Long nrOfTicketsSold = assignments.stream().map(t -> t.getSeats()).reduce(0L, Long::sum);
        if (nrOfTicketsSold + assignment.getSeats() > assignment.getConcert().getMaxNrOfTickets()) {
            throw new ServiceException("Sold out", HttpStatus.CONFLICT) ;
        }
        return assignmentRepository.save(assignment);
    }*/

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
