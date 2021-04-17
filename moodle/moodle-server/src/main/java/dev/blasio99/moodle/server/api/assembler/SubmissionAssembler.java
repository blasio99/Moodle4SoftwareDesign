package dev.blasio99.moodle.server.api.assembler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import dev.blasio99.moodle.common.dto.SubmissionDTO;

import dev.blasio99.moodle.server.model.Submission;

@Component
public class SubmissionAssembler { //} implements BaseAssembler<SubmissionDTO, Submission>{
	
	/*private DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Override
    public Submission createModel(SubmissionDTO dto) {
        Submission assignment = new Submission();
		assignment.setId(dto.getId());
		assignment.setLaboratoryNumber(dto.getLaboratoryNumber());
		assignment.setName(dto.getName());
		assignment.setDeadline(LocalDateTime.parse(dto.getDeadline(), dtf));
		assignment.setDescription(dto.getDescription());
        return assignment;
    }

    @Override
    public SubmissionDTO createDTO(Submission model) {
		SubmissionDTO dto = new SubmissionDTO();
		dto.setId(model.getId());
        dto.setLaboratoryNumber(model.getLaboratoryNumber());
        dto.setName(model.getName());
		dto.setDeadline(dtf.format(model.getDeadline()));
        dto.setDescription(model.getDescription());
        return dto;
    }*/
}