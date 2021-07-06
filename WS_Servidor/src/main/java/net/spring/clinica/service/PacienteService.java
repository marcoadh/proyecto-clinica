package net.spring.clinica.service;

import java.util.List;

import net.spring.clinica.entity.Paciente;

public interface PacienteService {

	public void save(Paciente bean);
	public void update(Paciente bean);
	public void delete(int cod);
	public Paciente findId(int cod);
	public List<Paciente> listAll();
}
