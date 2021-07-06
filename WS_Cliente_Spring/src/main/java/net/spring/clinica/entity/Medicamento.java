package net.spring.clinica.entity;

import java.io.Serializable;

public class Medicamento implements Serializable{

	private int codigoMedicamento;
	private String nombre;
	private String concentracion;
	private String presentacion;
	
	public int getCodigoMedicamento() {
		return codigoMedicamento;
	}
	public void setCodigoMedicamento(int codigoMedicamento) {
		this.codigoMedicamento = codigoMedicamento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getConcentracion() {
		return concentracion;
	}
	public void setConcentracion(String concentracion) {
		this.concentracion = concentracion;
	}
	public String getPresentacion() {
		return presentacion;
	}
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}
}
