package com.example.jwt.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.RolesAllowed;

@RestController
public class HelloWorldController {

	
	@PreAuthorize("hasRole('ROLE_RESPONSABLE_AULA')  OR hasRole('ROLE_VIGILANTE_AULA')")	
	@RequestMapping({ "/ejemplo1" })
	public String ejemplo1() {
		return "Ejemplo1";
	}	
	
	@PreAuthorize("hasRole('ROLE_CORRECTOR')")
	@RequestMapping({ "/ejemplo2" })
	public String ejemplo2() {
		return "Ejemplo2";
	}		

}