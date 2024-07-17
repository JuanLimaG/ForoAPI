package com.mx.ForoAPI.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.mx.ForoAPI.entity.Usuario;

@Service
public class TokenService {


	@Value("${api.security.secret}")
	private String apisecret;
	
	public String generarToken(Usuario user) {
		try {
		    Algorithm algorithm = Algorithm.HMAC256(apisecret);
		   return JWT.create()
		        .withIssuer("foroaluradb")
		        .withSubject(user.getEmail())
		        .withClaim("id", user.getIdUsuario())
		        .sign(algorithm);
		} catch (JWTCreationException exception){
		    throw new RuntimeException();
		}
	}
	
	
	public String getSubject(String token) {
		
		DecodedJWT verifier = null;
		try {
		    Algorithm algorithm = Algorithm.HMAC256(apisecret);
		    verifier = JWT.require(algorithm)
		        .withIssuer("foroaluradb")
		        .build()
		        .verify(token);
		   verifier.getSubject();     
		} catch (JWTVerificationException exception){
		    // Invalid signature/claims
		}
		if(verifier.getSubject() == null) {
			throw new RuntimeException("Invalid Verifier");
		}
		return verifier.getSubject();
	}
	
	
}
