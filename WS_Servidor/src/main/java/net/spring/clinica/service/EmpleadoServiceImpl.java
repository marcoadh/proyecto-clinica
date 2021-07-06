package net.spring.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.spring.clinica.dao.EmpleadoDAO;
import net.spring.clinica.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
	private EmpleadoDAO empleadoDAO;

	@Override
	public void save(Empleado bean) {
		empleadoDAO.save(bean);
		
	}

	@Override
	public void update(Empleado bean) {
		empleadoDAO.update(bean);
		
	}

	@Override
	public void delete(int cod) {
		empleadoDAO.delete(cod);
		
	}

	@Override
	public Empleado findId(int cod) {
		// TODO Auto-generated method stub
		return empleadoDAO.findId(cod);
	}

	@Override
	public List<Empleado> listAll() {
		// TODO Auto-generated method stub
		return empleadoDAO.listAll();
	}

}
