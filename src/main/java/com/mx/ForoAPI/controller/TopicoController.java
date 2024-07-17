package com.mx.ForoAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ForoAPI.dao.TopicoRepository;
import com.mx.ForoAPI.dao.UsuarioRepository;
import com.mx.ForoAPI.entity.ActualizarTopico;
import com.mx.ForoAPI.entity.DatosTopico;
import com.mx.ForoAPI.entity.Topico;
import com.mx.ForoAPI.entity.Usuario;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping
public class TopicoController {
	
	@Autowired
	private TopicoRepository topicoRepo; 
	

	@Autowired
	private UsuarioRepository userRepo; 
	
	
	@PostMapping("/newTopic")
	public void newTopico(@RequestBody DatosTopico newTopico) {
		Usuario autor = userRepo.getReferenceById(newTopico.autorId());
		Topico topico = topicoRepo.save(new Topico(newTopico, autor));
	}
	
	@GetMapping("/topics")
	public List<Topico> GetAllUsers() {
		return topicoRepo.findAll();
	}
	
	@PutMapping("/updTopic")
    @Transactional
    public void updateTopic(@RequestBody ActualizarTopico updTopic) {
		Usuario autor = userRepo.getReferenceById(updTopic.autorId());
		Topico topico = topicoRepo.getReferenceById(updTopic.id());
		topico.actualizarTopico(updTopic, autor);
	}
	
	
    @DeleteMapping("/{id}/topics")
    @Transactional
    public void eliminar(@PathVariable int id) {
        Topico topico = topicoRepo.getReferenceById(id);
        //topicoRepository.delete(topico);
        topicoRepo.delete(topico);
       // return ResponseEntity.noContent().build();
    }
	
	

}
