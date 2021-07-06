package net.spring.clinica.entity;

import java.io.Serializable;

public class Especialidad implements Serializable{

	private int codigoEspecialidad;
	private String nombre;
	
	public int getCodigoEspecialidad() {
		return codigoEspecialidad;
	}
	public void setCodigoEspecialidad(int codigoEspecialidad) {
		this.codigoEspecialidad = codigoEspecialidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Especialidad(int esp) {
		codigoEspecialidad = esp;
	}
	public Especialidad() {
		
	}
}
