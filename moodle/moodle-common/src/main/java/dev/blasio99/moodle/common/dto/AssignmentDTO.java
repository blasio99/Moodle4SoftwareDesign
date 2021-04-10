package dev.blasio99.moodle.common.dto;

public class AssignmentDTO extends BaseDTO{
	
	private Long laboratoryId;
	private String name;
	private String deadline;
	private String description;

	public Long getLaboratoryId() {
		return this.laboratoryId;
	}

	public void setLaboratoryId(Long laboratoryId) {
		this.laboratoryId = laboratoryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeadline() {
		return this.deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
