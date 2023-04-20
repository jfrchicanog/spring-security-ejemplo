package com.example.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.dto.JwtRequestDTO;
import com.example.jwt.dto.JwtResponseDTO;
import com.example.jwt.dto.UsuarioDTO;
import com.example.jwt.security.CustomAuthenticationManager;
import com.example.jwt.security.JwtUtil;
import com.example.jwt.service.JwtUserDetailsService;

@RestController
public class LoginController {
	
	@Autowired
	private JwtUserDetailsService userDetailsService;	
	@Autowired
	private CustomAuthenticationManager authenticationManager;	
	
	@Autowired
	private JwtUtil jwtTokenUtil;	
	
	
	@PostMapping("/register")
	public ResponseEntity<?> saveUser(@RequestBody UsuarioDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}	

	private void authenticate(String username, String password) throws Exception {
	try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	} catch (DisabledException e) {
		throw new Exception("USER_DISABLED", e);
	} catch (BadCredentialsException e) {
		throw new Exception("INVALID_CREDENTIALS", e);
	}
}
	
	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequestDTO authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponseDTO(token));
	}

}
