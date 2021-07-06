package net.spring.clinica.dao;

import java.util.List;

import net.spring.clinica.entity.Cita;

public interface CitaDAO {
	
	public void save(Cita bean);
	public void update(Cita bean);
	public void delete(int cod);
	public Cita findId(int cod);
	public List<Cita> listAll();
}
