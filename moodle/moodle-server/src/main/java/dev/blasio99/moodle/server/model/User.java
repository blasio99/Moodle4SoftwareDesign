package dev.blasio99.moodle.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import dev.blasio99.moodle.server.enums.Roles;

@Entity
@Table
public class User extends BaseModel {
    
    @Column(unique = true)
    private String username;
    private String password;
	@Enumerated(EnumType.STRING)
    private Roles role;

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

	public Roles getRole() {
		return this.role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}


	
}