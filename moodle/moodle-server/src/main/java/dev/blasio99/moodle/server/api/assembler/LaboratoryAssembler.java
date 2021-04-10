package dev.blasio99.moodle.server.api.assembler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import dev.blasio99.moodle.common.dto.LaboratoryDTO;
import dev.blasio99.moodle.server.model.Laboratory;

@Component
public class LaboratoryAssembler implements BaseAssembler<LaboratoryDTO, Laboratory>{
	private DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Override
    public Laboratory createModel(LaboratoryDTO dto) {
        Laboratory laboratory = new Laboratory();
        laboratory.setId(dto.getId());
		laboratory.setNumber(dto.getNumber());
		laboratory.setDate(LocalDateTime.parse(dto.getDate(), dtf));
        laboratory.setTitle(dto.getTitle());
        laboratory.setCurricula(dto.getCurricula());
        laboratory.setDescription(dto.getDescription());
        return laboratory;
    }

    @Override
    public LaboratoryDTO createDTO(Laboratory model) {
        LaboratoryDTO dto = new LaboratoryDTO();
        dto.setId(model.getId());
		dto.setNumber(model.getNumber());
        dto.setDate(dtf.format(model.getDate()));
        dto.setTitle(model.getTitle());
        dto.setCurricula(model.getCurricula());
        dto.setDescription(model.getDescription());
        return dto;
    }
}
