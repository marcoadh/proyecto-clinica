package net.spring.clinica.dao;

import java.util.List;

import net.spring.clinica.entity.Especialidad;

public interface EspecialidadDAO {

	public void save(Especialidad bean);
	public void update(Especialidad bean);
	public void delete(int cod);
	public Especialidad findId(int cod);
	public List<Especialidad> listAll();
}
