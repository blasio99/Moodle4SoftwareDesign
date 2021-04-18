package dev.blasio99.moodle.common.dto;

public class AttendanceDTO extends BaseDTO{
	
	private String username;
	private Integer week;
	private String status;

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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
