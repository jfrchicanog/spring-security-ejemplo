package com.example.jwt.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.example.jwt.entities.Usuario.Role;


public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username; 
	private String password;
	
	private Set<Role> roles = new HashSet<Role>();



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}