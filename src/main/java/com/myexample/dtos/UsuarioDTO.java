package com.myexample.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username; 
	private String password;
	private String name;
	private String surname1;
	private String surname2; 
	
	public enum Role{
		RESPONSABLE_AULA,
		VIGILANTE_AULA,
		RESPONSABLE_SEDE,
		CORRECTOR,
		ESTUDIANTE
	}
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname1() {
		return surname1;
	}

	public void setSurname1(String surname1) {
		this.surname1 = surname1;
	}

	public String getSurname2() {
		return surname2;
	}

	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}