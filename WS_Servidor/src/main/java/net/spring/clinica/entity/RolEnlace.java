package net.spring.clinica.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rol_enlace database table.
 * 
 */
@Entity
@Table(name="rol_enlace")
@NamedQuery(name="RolEnlace.findAll", query="SELECT r FROM RolEnlace r")
public class RolEnlace implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RolEnlacePK id;

	@ManyToOne
	@JoinColumn(name="idEnlace",referencedColumnName="idEnlace",insertable=false,updatable=false)
	private Enlace enlace;
	@ManyToOne
	@JoinColumn(name="idRol",referencedColumnName="idRol",insertable=false,updatable=false)
	private Rol rol;
	
	public RolEnlace() {
	}

	public RolEnlacePK getId() {
		return this.id;
	}

	public void setId(RolEnlacePK id) {
		this.id = id;
	}

}