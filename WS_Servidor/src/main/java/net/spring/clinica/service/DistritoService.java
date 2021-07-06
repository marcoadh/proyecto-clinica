package net.spring.clinica.service;

import java.util.List;

import net.spring.clinica.entity.Distrito;

public interface DistritoService {

	public void save(Distrito bean);
	public void update(Distrito bean);
	public void delete(int cod);
	public Distrito findId(int cod);
	public List<Distrito> listAll();
}
