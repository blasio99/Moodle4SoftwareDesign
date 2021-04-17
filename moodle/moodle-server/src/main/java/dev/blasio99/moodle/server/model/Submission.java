package dev.blasio99.moodle.server.model;

import java.time.LocalDateTime;

public class Submission {
	private Long assignmentId;
	private Long userId;
	private LocalDateTime submissionDate;
	private String gitLink;
	private String description;
	private double grade;

	public Long getAssignmentId() {
		return this.assignmentId;
	}

	public void setAssignmentId(Long assignmentId) {
		this.assignmentId = assignmentId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public LocalDateTime getSubmissionDate() {
		return this.submissionDate;
	}

	public void setSubmissionDate(LocalDateTime submissionDate) {
		this.submissionDate = submissionDate;
	}

	public String getGitLink() {
		return this.gitLink;
	}

	public void setGitLink(String gitLink) {
		this.gitLink = gitLink;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getGrade() {
		return this.grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

}
