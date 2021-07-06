package net.spring.clinica.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@Table(name="rol")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRol;

	private String descripcion;

	@JsonIgnore
	@OneToMany(mappedBy="rol")
	private List<RolEnlace> rolenlaces;
	
	@JsonIgnore
	@OneToMany(mappedBy="rol")
	private List<Usuario> listaUsuario;
	
	public Rol() {
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

	public List<RolEnlace> getRolenlaces() {
		return rolenlaces;
	}

	public void setRolenlaces(List<RolEnlace> rolenlaces) {
		this.rolenlaces = rolenlaces;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	

}