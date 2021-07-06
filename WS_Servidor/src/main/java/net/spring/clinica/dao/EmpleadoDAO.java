package net.spring.clinica.dao;

import java.util.List;

import net.spring.clinica.entity.Empleado;

public interface EmpleadoDAO {

	public void save(Empleado bean);
	public void update(Empleado bean);
	public void delete(int cod);
	public Empleado findId(int cod);
	public List<Empleado> listAll();
}
