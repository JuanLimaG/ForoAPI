package com.mx.ForoAPI.entity;


import java.time.LocalDateTime;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="topicos")
public class Topico {
	

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", columnDefinition ="int") 
	private int id;
	@Column(name="titulo", columnDefinition ="varchar(255)") 
	private String titulo;
	@Column(name="mensaje", columnDefinition ="varchar(255)") 
	private String mensaje;
	@Column(name="fechacreacion", columnDefinition ="DATE") 
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	@Column(name="estado", columnDefinition ="varchar(255)") 
	private String estado;
	@Column(name="cursoid", columnDefinition ="int") 
	private int cursoId;
	//@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "autorid", referencedColumnName = "idusuario") 
	@Fetch(FetchMode.JOIN)
	private Usuario autorId; 

//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "topicoId", referencedColumnName = "idusuario")

	
	
	public Topico(DatosTopico datos, Usuario autor) {
		this.titulo = datos.titulo();
		this.mensaje = datos.mensaje();
		this.autorId = autor;
		this.estado = datos.estado();
		this.cursoId = datos.cursoId();
	}
	
	public void actualizarTopico(ActualizarTopico datos, Usuario autor) {
		
		if(datos.titulo()!=null) {
			this.titulo = datos.titulo();
		}
		if(datos.mensaje() !=null) {
			this.mensaje = datos.mensaje();
		}
		
		if(datos.estado() !=null) {
			this.estado = datos.estado();
		}
		
		if(autor !=null) {
			this.autorId = autor;
		}
		
		if(datos.cursoId() !=0) {
			this.cursoId = datos.cursoId();
		}
		
	}
	
	public Topico() {
	}

	public Topico(int id, String titulo, String mensaje, LocalDateTime fechaCreacion, String estado, Usuario autorId,
			int cursoId) {
		this.id = id;
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.autorId = autorId;
		this.cursoId = cursoId;
	}

	@Override
	public String toString() {
		return "Topico [id=" + id + ", titulo=" + titulo + ", mensaje=" + mensaje + ", fechaCreacion=" + fechaCreacion
				+ ", estado=" + estado + ", autorId=" + autorId + ", cursoId=" + cursoId + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Usuario getAutorId() {
		return autorId;
	}

	public void setAutorId(Usuario autorId) {
		this.autorId = autorId;
	}

	public int getCursoId() {
		return cursoId;
	}

	public void setCursoId(int cursoId) {
		this.cursoId = cursoId;
	}
	
	



    
	
	

}
