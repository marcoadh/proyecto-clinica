package net.spring.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.spring.clinica.dao.RolDAO;
import net.spring.clinica.entity.Rol;

@Service
public class RolServiceImpl implements RolService{
	
	@Autowired
	private RolDAO rolDAO;

	@Override
	public void save(Rol bean) {
		rolDAO.save(bean);
		
	}

	@Override
	public void update(Rol bean) {
		rolDAO.update(bean);
		
	}

	@Override
	public void delete(int cod) {
		rolDAO.delete(cod);
		
	}

	@Override
	public Rol findId(int cod) {
		// TODO Auto-generated method stub
		return rolDAO.findId(cod);
	}

	@Override
	public List<Rol> listAll() {
		// TODO Auto-generated method stub
		return rolDAO.listAll();
	}

}
