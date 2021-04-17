package dev.blasio99.moodle.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.blasio99.moodle.server.exception.ServiceException;
import dev.blasio99.moodle.server.model.Laboratory;
import dev.blasio99.moodle.server.repo.LaboratoryRepository;

@Service
public class LaboratoryService {
	@Autowired
    private LaboratoryRepository laboratoryRepository;

    public Laboratory getLaboratoryByTitle(String title) {
        return laboratoryRepository.findByTitle(title);
    }

    public List<Laboratory> getLaboratoriesByNumber(Integer number) throws ServiceException {
		return laboratoryRepository.findByNumber(number);
    }

    public Laboratory addLaboratory(Laboratory laboratory) {
        return laboratoryRepository.save(laboratory);
    }

	public Laboratory updateLaboratory(Laboratory laboratory) throws ServiceException {
        Laboratory lab = laboratoryRepository.findByTitle(laboratory.getTitle());
        //check if a laboratory with the new name does not exist
        if (lab != null && !(lab.getId().equals(laboratory.getId()))) throw new ServiceException("Laboratory name already exists!", HttpStatus.CONFLICT);
        return laboratoryRepository.save(laboratory);
    }

    public void deleteLaboratory(String title) {
        Laboratory assignment = laboratoryRepository.findByTitle(title);
        if (assignment == null) return;
        laboratoryRepository.delete(assignment);
    }
}
