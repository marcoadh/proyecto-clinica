package net.spring.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.spring.clinica.dao.CitaDAO;
import net.spring.clinica.entity.Cita;

@Service
public class CitaServiceImpl implements CitaService {
	
	@Autowired
	private CitaDAO citaDAO;

	@Override
	public void save(Cita bean) {
		citaDAO.save(bean);
		
	}

	@Override
	public void update(Cita bean) {
		citaDAO.update(bean);
		
	}

	@Override
	public void delete(int cod) {
		citaDAO.delete(cod);
		
	}

	@Override
	public Cita findId(int cod) {
		// TODO Auto-generated method stub
		return citaDAO.findId(cod);
	}

	@Override
	public List<Cita> listAll() {
		// TODO Auto-generated method stub
		return citaDAO.listAll();
	}

}
