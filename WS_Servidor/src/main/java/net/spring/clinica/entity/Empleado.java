package net.spring.clinica.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="empleado")
public class Empleado implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEmpleado")
	private int codigoEmpleado;
	
	@Column(name = "nombre")
	private String nombres;
	
	@Column(name = "apellido")
	private String apellidos;
	
	@Column(name = "sexo")
	private String sexo;
	
	/*
	@Temporal(TemporalType.DATE)
	@Column(name = "fec_reg_emp")
	private Date fechaRegistro;
	*/
	
	
	//relación muchos "Empleado" a uno "TipoEmpleado"
	@ManyToOne
	@JoinColumn(name = "idTipoEmpleado")
	private TipoEmpleado tipoEmpleado;//ASOCIACIÓN
	
	
	@JsonIgnore
	//relación uno "Empleado" a muchos "Usuario"
	@OneToMany(mappedBy = "empleado")//ASOCIACIÓN
	private List<Usuario> listaUsuario;

	
	public int getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(int codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}


	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	
	
}








