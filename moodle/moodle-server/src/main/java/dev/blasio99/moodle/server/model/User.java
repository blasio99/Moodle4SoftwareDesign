package dev.blasio99.moodle.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import dev.blasio99.moodle.server.enums.GroupName;
import dev.blasio99.moodle.server.enums.Role;

@Entity
@Table
public class User extends BaseModel {
    
    @Column(unique = true)
	private String email;
	@Column(unique = true)
	private String username;
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	@Enumerated(EnumType.STRING)
	private GroupName groupName;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public GroupName getGroupName() {
		return this.groupName;
	}

	public void setGroupName(GroupName groupName) {
		this.groupName = groupName;
	}

	public String getHobby() {
		return this.hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	


	
}