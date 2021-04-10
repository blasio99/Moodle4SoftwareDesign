package dev.blasio99.moodle.common.dto;

public class UserRegisterDTO extends UserDTO {
    
	private String password;

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}  
}