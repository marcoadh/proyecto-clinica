package net.spring.clinica.dao;

import java.util.List;

import net.spring.clinica.entity.Distrito;

public interface DistritoDAO {

	public void save(Distrito bean);
	public void update(Distrito bean);
	public void delete(int cod);
	public Distrito findId(int cod);
	public List<Distrito> listAll();
}
