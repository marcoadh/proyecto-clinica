package net.spring.clinica.service;

import java.util.List;

import net.spring.clinica.entity.Especialidad;

public interface EspecialidadService {

	public void save(Especialidad bean);
	public void update(Especialidad bean);
	public void delete(int cod);
	public Especialidad findId(int cod);
	public List<Especialidad> listAll();
}
