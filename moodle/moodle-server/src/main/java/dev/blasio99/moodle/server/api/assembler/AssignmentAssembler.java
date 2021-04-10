package dev.blasio99.moodle.server.api.assembler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import dev.blasio99.moodle.common.dto.AssignmentDTO;

import dev.blasio99.moodle.server.model.Assignment;

@Component
public class AssignmentAssembler implements BaseAssembler<AssignmentDTO, Assignment>{
	
	private DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Override
    public Assignment createModel(AssignmentDTO dto) {
        Assignment assignment = new Assignment();
		assignment.setId(dto.getId());
		assignment.setLaboratoryNumber(dto.getLaboratoryNumber());
		assignment.setName(dto.getName());
		assignment.setDeadline(LocalDateTime.parse(dto.getDeadline(), dtf));
		assignment.setDescription(dto.getDescription());
        return assignment;
    }

    @Override
    public AssignmentDTO createDTO(Assignment model) {
        AssignmentDTO dto = new AssignmentDTO();
		dto.setId(model.getId());
        dto.setLaboratoryNumber(model.getLaboratoryNumber());
        dto.setName(model.getName());
		dto.setDeadline(dtf.format(model.getDeadline()));
        dto.setDescription(model.getDescription());
        return dto;
    }
}
