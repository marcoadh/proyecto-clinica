package net.spring.clinica.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicamento")
public class Medicamento implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idMedicamento")
	private int codigoMedicamento;
	
	@Column(name = "nombreMedicamento")
	private String nombre;
	
	@Column(name = "concentracion")
	private String concentracion;
	
	@Column(name = "presentacion")
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
