package dev.blasio99.moodle.common.dto;

public class UserDTO extends BaseDTO{
    
    private String email;
	private String username;
	private String role;
	private String groupName;
	private String hobby;

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getHobby() {
		return this.hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

}