package dev.blasio99.moodle.server.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dev.blasio99.moodle.server.model.Laboratory;

public interface LaboratoryRepository extends CrudRepository<Laboratory, Long>{
	public Laboratory findByTitle(String title);
    public List<Laboratory> findByNumber(Integer number);
}
