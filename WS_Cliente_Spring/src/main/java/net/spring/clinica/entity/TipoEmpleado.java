package net.spring.clinica.entity;

import java.io.Serializable;

public class TipoEmpleado implements Serializable{

	private int codigoTipoEmpleado;
	private String nombreTipoEmpleado;
	
	

	public TipoEmpleado() {
		
	}
	
	
	public int getCodigoTipoEmpleado() {
		return codigoTipoEmpleado;
	}


	public void setCodigoTipoEmpleado(int codigoTipoEmpleado) {
		this.codigoTipoEmpleado = codigoTipoEmpleado;
	}


	public String getNombreTipoEmpleado() {
		return nombreTipoEmpleado;
	}


	public void setNombreTipoEmpleado(String nombreTipoEmpleado) {
		this.nombreTipoEmpleado = nombreTipoEmpleado;
	}


	public TipoEmpleado(int tipo) {
		codigoTipoEmpleado = tipo;
	}
}
