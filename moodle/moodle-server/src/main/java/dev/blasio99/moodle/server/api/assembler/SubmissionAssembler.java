package dev.blasio99.moodle.server.api.assembler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import dev.blasio99.moodle.common.dto.SubmissionDTO;

import dev.blasio99.moodle.server.model.Submission;

@Component
public class SubmissionAssembler{
	
	private DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public Submission createModel(SubmissionDTO dto) {
        Submission assignment = new Submission();
		assignment.setSubmissionId(dto.getSubmissionId());
		assignment.setAssignmentId(dto.getAssignmentId());
		assignment.setUserId(dto.getUserId());
		assignment.setSubmissionDate(LocalDateTime.parse(dto.getSubmissionDate(), dtf));
		assignment.setGitLink(dto.getGitLink());
		assignment.setDescription(dto.getDescription());
		assignment.setGrade(dto.getGrade());
        return assignment;
    }

    public SubmissionDTO createDTO(Submission model) {
		SubmissionDTO dto = new SubmissionDTO();
		dto.setSubmissionId(model.getSubmissionId());
		dto.setAssignmentId(model.getAssignmentId());
		dto.setUserId(model.getUserId());
		dto.setSubmissionDate(dtf.format(model.getSubmissionDate()));
		dto.setGitLink(model.getGitLink());
		dto.setDescription(model.getDescription());
		dto.setGrade(model.getGrade());
        return dto;
    }

	public List<Submission> createModelList(List<SubmissionDTO> dtoList) {
        List<Submission> models = new ArrayList<>(dtoList.size());
        for (SubmissionDTO dto : dtoList) {
            models.add(createModel(dto));
        }
        return models;
    }

    public List<SubmissionDTO> createDTOList(List<Submission> models) {
        List<SubmissionDTO> dtoList = new ArrayList<>(models.size());
        for (Submission model : models) {
            dtoList.add(createDTO(model));
        }
        return dtoList;
    }
}