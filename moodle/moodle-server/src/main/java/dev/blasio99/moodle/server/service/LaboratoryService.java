package dev.blasio99.moodle.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.blasio99.moodle.server.model.Laboratory;
import dev.blasio99.moodle.server.repo.LaboratoryRepository;

@Service
public class LaboratoryService {
	@Autowired
    private LaboratoryRepository laboratoryRepository;

    public List<Laboratory> getLaboratoriesByTitle(String title) {
        return laboratoryRepository.findByTitle(title);
    }

    public List<Laboratory> getLaboratoriesByNumber(Integer number) throws ServiceException {
		return laboratoryRepository.findByNumber(number);
    }

    public Laboratory addLaboratory(Laboratory laboratory) {
        return laboratoryRepository.save(laboratory);
    }
}
