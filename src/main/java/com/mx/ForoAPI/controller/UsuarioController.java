package com.mx.ForoAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ForoAPI.dao.UsuarioRepository;
import com.mx.ForoAPI.entity.ActualizarUsuario;
import com.mx.ForoAPI.entity.DatosUsuario;
import com.mx.ForoAPI.entity.Usuario;

import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository userRepo; 
	
	public UsuarioController(UsuarioRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@PostMapping("/add")
	public void newUser(@RequestBody DatosUsuario newUs) {
		userRepo.save(new Usuario(newUs));
	}
	
	@GetMapping("/users")
	public List<Usuario> GetAllUsers() {
		return userRepo.findAll();
	}
	
	@PutMapping("/upd")
	@Transactional
	public void updateUser(@RequestBody ActualizarUsuario updUs) {
		Usuario us = userRepo.getReferenceById(updUs.idUsuario());
		us.actualizarUsuario(updUs);
	}
	
	@DeleteMapping("/{idUsuario}")
	public void deleteUser(@PathVariable int idUsuario) {
		Usuario us = userRepo.getReferenceById(idUsuario);
		userRepo.delete(us);
	}
	
}
