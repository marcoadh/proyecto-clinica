package net.spring.clinica.dao;

import java.util.List;

import net.spring.clinica.entity.Paciente;

public interface PacienteDAO {

	public void save(Paciente bean);
	public void update(Paciente bean);
	public void delete(int cod);
	public Paciente findId(int cod);
	public List<Paciente> listAll();
}
