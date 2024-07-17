package com.mx.ForoAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ForoAPI.entity.DatosUsuario;
import com.mx.ForoAPI.entity.Usuario;
import com.mx.ForoAPI.security.JWTData;
import com.mx.ForoAPI.security.TokenService;



@RestController
@RequestMapping("/login")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authManag;
	
	@Autowired
	private TokenService tokenserv;
	
	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity authUser(@RequestBody DatosUsuario data) {
		var authtoken = new UsernamePasswordAuthenticationToken(data.email(), data.contrasena());
		var  authentication = authManag.authenticate(authtoken);
		var token = tokenserv.generarToken((Usuario) authentication.getPrincipal());
		return ResponseEntity.ok(new JWTData(token));
	}
}
