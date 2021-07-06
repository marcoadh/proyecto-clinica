package net.spring.clinica.service;

import java.util.List;

import net.spring.clinica.entity.Cita;

public interface CitaService {

	public void save(Cita bean);
	public void update(Cita bean);
	public void delete(int cod);
	public Cita findId(int cod);
	public List<Cita> listAll();
}
