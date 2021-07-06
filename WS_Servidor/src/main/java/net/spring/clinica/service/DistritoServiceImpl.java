package net.spring.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.spring.clinica.dao.DistritoDAO;
import net.spring.clinica.entity.Distrito;

@Service
public class DistritoServiceImpl implements DistritoService{
	
	@Autowired
	private DistritoDAO distritoDAO;

	@Override
	public void save(Distrito bean) {
		distritoDAO.save(bean);
		
	}

	@Override
	public void update(Distrito bean) {
		distritoDAO.update(bean);
		
	}

	@Override
	public void delete(int cod) {
		distritoDAO.delete(cod);
		
	}

	@Override
	public Distrito findId(int cod) {
		// TODO Auto-generated method stub
		return distritoDAO.findId(cod);
	}

	@Override
	public List<Distrito> listAll() {
		// TODO Auto-generated method stub
		return distritoDAO.listAll();
	}

}
