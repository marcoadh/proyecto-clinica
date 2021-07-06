package net.spring.clinica.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="especialidad")
public class Especialidad implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEspecialidad")
	private int codigoEspecialidad;
	
	@Column(name = "descripcion")
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
}
