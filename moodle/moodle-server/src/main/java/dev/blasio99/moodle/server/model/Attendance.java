package dev.blasio99.moodle.server.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import dev.blasio99.moodle.server.enums.Status;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"username", "week"})) 
public class Attendance extends BaseModel{
	
	private String username;
	private Integer week;
	@Enumerated(EnumType.STRING)
	private Status status;

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getWeek() {
		return this.week;
	}

	public void setWeek(Integer week) {
		this.week = week;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
