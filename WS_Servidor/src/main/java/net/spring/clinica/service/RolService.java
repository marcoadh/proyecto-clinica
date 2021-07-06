package net.spring.clinica.service;

import java.util.List;

import net.spring.clinica.entity.Rol;

public interface RolService {

	public void save(Rol bean);
	public void update(Rol bean);
	public void delete(int cod);
	public Rol findId(int cod);
	public List<Rol> listAll();
}
