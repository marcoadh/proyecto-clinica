package net.spring.clinica.service;

import java.util.List;

import net.spring.clinica.entity.Empleado;

public interface EmpleadoService {

	public void save(Empleado bean);
	public void update(Empleado bean);
	public void delete(int cod);
	public Empleado findId(int cod);
	public List<Empleado> listAll();
}
