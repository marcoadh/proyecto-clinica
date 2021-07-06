package net.spring.clinica.entity;

import java.io.Serializable;

public class Empleado implements Serializable{

	private int codigoEmpleado;
	private String nombres;
	private String apellidos;
	private String sexo;
	private TipoEmpleado tipoEmpleado;
	
	public Empleado() {
		
	}
	
	public Empleado(int cod) {
		codigoEmpleado = cod;
	}
	
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
	
	
}
