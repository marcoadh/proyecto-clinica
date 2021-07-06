package net.spring.clinica.dao;

import java.util.List;

import net.spring.clinica.entity.Medicamento;

public interface MedicamentoDAO {

	public void save(Medicamento bean);
	public void update(Medicamento bean);
	public void delete(int cod);
	public Medicamento findId(int cod);
	public List<Medicamento> listAll();
}
