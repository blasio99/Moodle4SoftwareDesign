package dev.blasio99.moodle.server.api.resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.blasio99.moodle.common.dto.LaboratoryDTO;

import dev.blasio99.moodle.server.api.assembler.LaboratoryAssembler;
import dev.blasio99.moodle.server.model.Laboratory;
import dev.blasio99.moodle.server.service.ServiceException;
import dev.blasio99.moodle.server.service.LaboratoryService;


@CrossOrigin("*")
@RestController
public class LaboratoryResource {

    @Autowired
    private LaboratoryService laboratoryService;

    @Autowired
    private LaboratoryAssembler laboratoryAssembler;

	
    @GetMapping("api/lab/title/{title}")
    public ResponseEntity<LaboratoryDTO> getLaboratoriesByTitle(@PathVariable String title) {
        try {
            LaboratoryDTO laboratory = laboratoryAssembler.createDTO(laboratoryService.getLaboratoryByTitle(title));
            return new ResponseEntity<>(laboratory, HttpStatus.OK);
        }
        catch(ServiceException e) {
            return new ResponseEntity<>(e.getHttpStatus());
        }
 
    }

    @GetMapping("api/lab/number/{number}")
    public List<LaboratoryDTO> getConcertsByPerformer(@PathVariable Integer number) {
        return laboratoryAssembler.createDTOList(laboratoryService.getLaboratoriesByNumber(number));
    }

    @PostMapping("admin/api/lab/add")
    public Laboratory addLaboratory(@RequestBody LaboratoryDTO dto) {
        return laboratoryService.addLaboratory(laboratoryAssembler.createModel(dto));
    }

	@GetMapping("api/lab/all")
	public List<LaboratoryDTO> getLaboratories() {

		List<LaboratoryDTO> list = new ArrayList<>();
		
		for(Integer labNumber = 0; labNumber < 14; ++labNumber){
			List<LaboratoryDTO> validList = laboratoryAssembler.createDTOList(laboratoryService.getLaboratoriesByNumber(labNumber));
			if(!validList.isEmpty())
				list = Stream.concat(list.stream(), validList.stream()).collect(Collectors.toList());
		}
        return list;
    }
	

}
