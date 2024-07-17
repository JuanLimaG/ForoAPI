package com.mx.ForoAPI.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario implements UserDetails{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idusuario", columnDefinition ="int") 
	private int idUsuario;
	@Column(name="nombre", columnDefinition ="varchar(255)") 
	private String nombre;
	@Column(name="email", columnDefinition ="varchar(255)") 
	private String email;
	@Column(name="contrasena", columnDefinition ="varchar(255)") 
	private String contrasena;
	@Column(name="tipo", columnDefinition ="varchar(255)") 
	private String tipo;
	
	
	
	public Usuario() {
	}
	
	public Usuario(DatosUsuario datos) {
		
		this.nombre = datos.nombre();
		this.email = datos.email();
		this.contrasena = datos.contrasena();
		this.tipo = datos.tipo();
	}
	
public void actualizarUsuario(ActualizarUsuario datos) {
		
		if(datos.nombre()!=null) {
			this.nombre = datos.nombre();
		}
		if(datos.email() !=null) {
			this.email = datos.email();
		}
		
		if(datos.contrasena() !=null) {
			this.contrasena = datos.contrasena();
		}
		
		if(datos.tipo() !=null) {
			this.tipo = datos.tipo();
		}
		
		
	}




	
	
	public Usuario(int idUsuario, String nombre, String email, String contrasena, String tipo) {
	this.idUsuario = idUsuario;
	this.nombre = nombre;
	this.email = email;
	this.contrasena = contrasena;
	this.tipo = tipo;
}
	
	

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", email=" + email + ", contrasena="
				+ contrasena + ", tipo=" + tipo + "]";
	}
	
	
	

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return contrasena;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

}
