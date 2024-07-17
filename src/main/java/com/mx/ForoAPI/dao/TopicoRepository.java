package com.mx.ForoAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mx.ForoAPI.entity.Topico;



public interface TopicoRepository extends JpaRepository<Topico, Integer>{

//	@Query("SELECT e FROM Topicos e JOIN FETCH e.Usuarios WHERE e.id = :id")
//	Topico findByIdWithOtraEntidad(@Param("id") int id);
}
