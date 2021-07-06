package net.spring.clinica.dao;

import java.util.List;

import net.spring.clinica.entity.TipoEmpleado;

public interface TipoEmpleadoDAO {

	public void save(TipoEmpleado bean);
	public void update(TipoEmpleado bean);
	public void delete(int cod);
	public TipoEmpleado findId(int cod);
	public List<TipoEmpleado> listAll();
}
