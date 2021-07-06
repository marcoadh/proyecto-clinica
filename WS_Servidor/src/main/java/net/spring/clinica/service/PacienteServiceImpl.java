package net.spring.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.spring.clinica.dao.PacienteDAO;
import net.spring.clinica.entity.Paciente;

@Service
public class PacienteServiceImpl implements PacienteService{
	
	@Autowired
	private PacienteDAO pacienteDAO;

	@Override
	public void save(Paciente bean) {
		pacienteDAO.save(bean);
		
	}

	@Override
	public void update(Paciente bean) {
		pacienteDAO.update(bean);
		
	}

	@Override
	public void delete(int cod) {
		pacienteDAO.delete(cod);
		
	}

	@Override
	public Paciente findId(int cod) {
		// TODO Auto-generated method stub
		return pacienteDAO.findId(cod);
	}

	@Override
	public List<Paciente> listAll() {
		// TODO Auto-generated method stub
		return pacienteDAO.listAll();
	}

}
