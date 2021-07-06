package net.spring.clinica.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rol_enlace database table.
 * 
 */
@Embeddable
public class RolEnlacePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idRol;

	private int idEnlace;

	public RolEnlacePK() {
	}
	public int getIdrol() {
		return this.idRol;
	}
	public void setIdrol(int idrol) {
		this.idRol = idrol;
	}
	public int getIdenlace() {
		return this.idEnlace;
	}
	public void setIdenlace(int idenlace) {
		this.idEnlace = idenlace;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RolEnlacePK)) {
			return false;
		}
		RolEnlacePK castOther = (RolEnlacePK)other;
		return 
			(this.idRol == castOther.idRol)
			&& (this.idEnlace == castOther.idEnlace);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idRol;
		hash = hash * prime + this.idEnlace;
		
		return hash;
	}
}