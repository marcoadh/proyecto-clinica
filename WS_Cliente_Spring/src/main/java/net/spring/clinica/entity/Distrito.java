package net.spring.clinica.entity;

import java.io.Serializable;

public class Distrito implements Serializable{

	private int codigoDistrito;
	private String nombre;
	
	
	
	
	public int getCodigoDistrito() {
		return codigoDistrito;
	}
	public void setCodigoDistrito(int codigoDistrito) {
		this.codigoDistrito = codigoDistrito;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Distrito(int cod) {
		codigoDistrito=cod;
	}
	public Distrito() {
		
	}
}
