package net.spring.clinica.entity;

import java.io.Serializable;

public class Enlace implements Serializable {

	private int idEnlace;
	private String descripcion;
	private String ruta;
	

	

	public int getIdEnlace() {
		return this.idEnlace;
	}

	public void setIdEnlace(int idEnlace) {
		this.idEnlace = idEnlace;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRuta() {
		return this.ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

}