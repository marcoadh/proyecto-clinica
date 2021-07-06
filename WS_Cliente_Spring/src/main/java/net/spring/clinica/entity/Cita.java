package net.spring.clinica.entity;

import java.io.Serializable;
import java.util.Date;

public class Cita implements Serializable{

	private int codigoCita;
	private String asunto;		
	private String enfermedad;	
	private String sintomas;
	private String fechaRegistro;
	private Paciente paciente;
	
	public int getCodigoCita() {
		return codigoCita;
	}
	public void setCodigoCita(int codigoCita) {
		this.codigoCita = codigoCita;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}
	public String getSintomas() {
		return sintomas;
	}
	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
