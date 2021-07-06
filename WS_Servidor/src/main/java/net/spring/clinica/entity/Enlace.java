package net.spring.clinica.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the enlace database table.
 * 
 */
@Entity
@Table(name="enlace")
@NamedQuery(name="Enlace.findAll", query="SELECT e FROM Enlace e")
public class Enlace implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEnlace;

	private String descripcion;

	private String ruta;
	
	@OneToMany(mappedBy="enlace")
	private List<RolEnlace> rolEnlace;
	
	
	public Enlace() {
	}
	
	

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