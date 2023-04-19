package com.myexample.services;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myexample.dtos.UsuarioDTO;
import com.myexample.entities.Usuario;
import com.myexample.entities.Usuario.Role;
import com.myexample.repositories.UsuarioRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private ModelMapper modelMapper;	
	
	@Autowired
	private UsuarioRepository userRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = userRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
		Set<SimpleGrantedAuthority> auths = new java.util.HashSet<SimpleGrantedAuthority>();
		Set<Role> roles = user.getRoles();
		roles.forEach(rol -> auths.add(new SimpleGrantedAuthority("ROLE_" + rol.toString())));
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				auths);
	}
	
	public Usuario save(UsuarioDTO user) {
		Usuario newUser = modelMapper.map(user, Usuario.class);
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepo.save(newUser);
	}
	

}