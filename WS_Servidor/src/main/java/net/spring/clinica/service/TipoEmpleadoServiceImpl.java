package net.spring.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.spring.clinica.dao.TipoEmpleadoDAO;
import net.spring.clinica.entity.TipoEmpleado;

@Service
public class TipoEmpleadoServiceImpl implements TipoEmpleadoService{
	
	@Autowired
	private TipoEmpleadoDAO tipoEmpleadoDAO;

	@Override
	public void save(TipoEmpleado bean) {
		tipoEmpleadoDAO.save(bean);
		
	}

	@Override
	public void update(TipoEmpleado bean) {
		tipoEmpleadoDAO.update(bean);
		
	}

	@Override
	public void delete(int cod) {
		tipoEmpleadoDAO.delete(cod);
		
	}

	@Override
	public TipoEmpleado findId(int cod) {
		// TODO Auto-generated method stub
		return tipoEmpleadoDAO.findId(cod);
	}

	@Override
	public List<TipoEmpleado> listAll() {
		// TODO Auto-generated method stub
		return tipoEmpleadoDAO.listAll();
	}

}
