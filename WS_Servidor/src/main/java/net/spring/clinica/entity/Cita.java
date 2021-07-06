package net.spring.clinica.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="cita")
public class Cita implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCita")
	private int codigoCita;	
	
	@Column(name = "asunto")
	private String asunto;
	
	@Column(name = "enfermedad")
	private String enfermedad;
	
	@Column(name = "sintomas")
	private String sintomas;
	
	/*
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT-5",locale="es_PE")
	@Temporal(TemporalType.TIMESTAMP)
	*/
	
	/*
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	*/
	@Column(name = "fechaReg")
	private String fechaRegistro;
	
	
	@ManyToOne
	@JoinColumn(name="idPaciente")
	private Paciente paciente;
	
	
	public Cita() {
		
	}
	
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
