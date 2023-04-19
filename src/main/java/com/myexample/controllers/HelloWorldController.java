package com.myexample.controllers;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}
	
	@PreAuthorize("hasRole('ROLE_RESPONSABLE_AULA') OR hasRole('ROLE_VIGILANTE_AULA')")
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