package dev.blasio99.moodle.server.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Assignment extends BaseModel{
	
	@ManyToOne
	private Laboratory laboratory;
	private String name;
	private LocalDateTime deadline;
	private String description;

	public Laboratory getLaboratory() {
		return this.laboratory;
	}

	public void setLaboratory(Laboratory laboratory) {
		this.laboratory = laboratory;
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
