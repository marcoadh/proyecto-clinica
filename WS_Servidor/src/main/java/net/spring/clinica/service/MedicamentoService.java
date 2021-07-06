package net.spring.clinica.service;

import java.util.List;

import net.spring.clinica.entity.Medicamento;

public interface MedicamentoService {

	public void save(Medicamento bean);
	public void update(Medicamento bean);
	public void delete(int cod);
	public Medicamento findId(int cod);
	public List<Medicamento> listAll();
}
