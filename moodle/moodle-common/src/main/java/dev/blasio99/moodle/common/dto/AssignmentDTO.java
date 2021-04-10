package dev.blasio99.moodle.common.dto;

public class AssignmentDTO extends BaseDTO{
	
	private Integer laboratoryNumber;
	private String name;
	private String deadline;
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
