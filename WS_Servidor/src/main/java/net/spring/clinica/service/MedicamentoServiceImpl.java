package net.spring.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.spring.clinica.dao.MedicamentoDAO;
import net.spring.clinica.entity.Medicamento;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {
	
	@Autowired
	private MedicamentoDAO medicamentoDAO;

	@Override
	public void save(Medicamento bean) {
		medicamentoDAO.save(bean);
		
	}

	@Override
	public void update(Medicamento bean) {
		medicamentoDAO.update(bean);
		
	}

	@Override
	public void delete(int cod) {
		medicamentoDAO.delete(cod);
		
	}

	@Override
	public Medicamento findId(int cod) {
		// TODO Auto-generated method stub
		return medicamentoDAO.findId(cod);
	}

	@Override
	public List<Medicamento> listAll() {
		// TODO Auto-generated method stub
		return medicamentoDAO.listAll();
	}

}
