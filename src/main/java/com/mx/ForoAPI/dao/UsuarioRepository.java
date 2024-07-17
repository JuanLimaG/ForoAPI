package com.mx.ForoAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.mx.ForoAPI.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
  UserDetails findByemail(String email); 
}
