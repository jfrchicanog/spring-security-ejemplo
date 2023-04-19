package com.myexample.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false, unique = true)
	private String username; //email
	@JsonIgnore
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String surname1;
	private String surname2; 
	
	public enum Role{
		RESPONSABLE_AULA,
		VIGILANTE_AULA,
		RESPONSABLE_SEDE,
		CORRECTOR,
		ESTUDIANTE
	}
	
	@Column(nullable = false)
	@ElementCollection(fetch = FetchType.EAGER) @Enumerated(EnumType.STRING)
	private Set<Role> roles = new HashSet<Role>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object o) {
	    if (o == this)
	        return true;
	    if (!(o instanceof Usuario))
	        return false;
		Usuario other = (Usuario) o;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "Usuario {id=" + id + ", nombre=" + name + "}";
	}
	
}