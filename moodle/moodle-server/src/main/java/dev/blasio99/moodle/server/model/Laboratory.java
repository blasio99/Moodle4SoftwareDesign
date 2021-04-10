package dev.blasio99.moodle.server.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class Laboratory extends BaseModel{
	private Integer number;
	private LocalDateTime date;
	private String title;
	private String curricula;
	private String description;

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalDateTime getDate() {
		return this.date;
	}

	public void setDate(LocalDateTime date) {
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
