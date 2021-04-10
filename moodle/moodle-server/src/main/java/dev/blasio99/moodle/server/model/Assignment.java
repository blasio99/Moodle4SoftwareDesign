package dev.blasio99.moodle.server.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class Assignment extends BaseModel{
	
	private Integer laboratoryNumber;
	private String name;
	private LocalDateTime deadline;
	private String description;

	public Integer getLaboratoryNumber() {
		return this.laboratoryNumber;
	}

	public void setLaboratoryNumber(Integer laboratoryNumber) {
		this.laboratoryNumber = laboratoryNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDeadline() {
		return this.deadline;
	}

	public void setDeadline(LocalDateTime deadline) {
		this.deadline = deadline;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
