package net.spring.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.spring.clinica.dao.EspecialidadDAO;
import net.spring.clinica.entity.Especialidad;

@Service
public class EspecialidadServiceImpl implements EspecialidadService{
	
	@Autowired
	private EspecialidadDAO especialidadDAO;

	@Override
	public void save(Especialidad bean) {
		especialidadDAO.save(bean);
		
	}

	@Override
	public void update(Especialidad bean) {
		especialidadDAO.update(bean);
		
	}

	@Override
	public void delete(int cod) {
		especialidadDAO.delete(cod);
		
	}

	@Override
	public Especialidad findId(int cod) {
		// TODO Auto-generated method stub
		return especialidadDAO.findId(cod);
	}

	@Override
	public List<Especialidad> listAll() {
		// TODO Auto-generated method stub
		return especialidadDAO.listAll();
	}

}
