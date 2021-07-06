package net.spring.clinica.entity;

import java.io.Serializable;

public class Rol implements Serializable {
	
	private int idRol;

	private String descripcion;

	
	public Rol() {
	}
	
	public Rol(int cod) {
		idRol = cod;
	}
	
	public int getIdRol() {
		return this.idRol;
	}


	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	

}