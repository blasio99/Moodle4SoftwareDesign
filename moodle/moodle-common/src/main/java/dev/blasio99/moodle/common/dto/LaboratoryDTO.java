package dev.blasio99.moodle.common.dto;

public class LaboratoryDTO extends BaseDTO{
    
    private Integer number;
	private String date;
	private String title;
	private String curricula;
	private String description;

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCurricula() {
		return this.curricula;
	}

	public void setCurricula(String curricula) {
		this.curricula = curricula;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
