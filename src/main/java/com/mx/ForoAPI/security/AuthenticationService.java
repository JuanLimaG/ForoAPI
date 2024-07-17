package com.mx.ForoAPI.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mx.ForoAPI.dao.UsuarioRepository;

@Service
public class AuthenticationService implements UserDetailsService{

	
	@Autowired
	private UsuarioRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userRepo.findByemail(username);
	}

}
