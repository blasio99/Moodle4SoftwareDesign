package dev.blasio99.untoldfestival.common.dto;

public class UserRegisterDTO extends UserDTO {
    
	private String username;
	private String password;

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


    
}