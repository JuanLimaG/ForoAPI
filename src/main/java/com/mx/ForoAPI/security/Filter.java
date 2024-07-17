package com.mx.ForoAPI.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mx.ForoAPI.dao.UsuarioRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class Filter extends OncePerRequestFilter{

	@Autowired
	private TokenService tokenserv;
	
	@Autowired
	private UsuarioRepository userRepo;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
	var JWToken  = getToken(request);
		
		if(JWToken !=null) {
			var subject = tokenserv.getSubject(JWToken);
			var usuario = userRepo.findByemail(subject);
			var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
		}
		
		 filterChain.doFilter(request, response);
	}
	
	private String getToken(HttpServletRequest request) {
		var authHeader = request.getHeader("Authorization");
		if(authHeader != null) {
			return authHeader.replace("Bearer ", "");
		}
		return null;
	}


}
