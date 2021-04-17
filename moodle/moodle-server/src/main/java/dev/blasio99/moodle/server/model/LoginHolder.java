package dev.blasio99.moodle.server.model;

import dev.blasio99.moodle.common.dto.UserRegisterDTO;

public class LoginHolder {
	UserRegisterDTO dto;
	String token;

	public UserRegisterDTO getDto() {
		return this.dto;
	}

	public void setDto(UserRegisterDTO dto) {
		this.dto = dto;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
