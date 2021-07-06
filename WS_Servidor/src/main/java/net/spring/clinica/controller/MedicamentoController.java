package net.spring.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.spring.clinica.entity.Medicamento;
import net.spring.clinica.service.MedicamentoService;

@RestController
@RequestMapping(value = "/medicamento")
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService medicamentoService;

	@GetMapping(path = "/listAllMedicamento")
	@ResponseBody
	public List<Medicamento> listAllMedicamento(){
		return medicamentoService.listAll();
	}	
	
	@GetMapping(path = "/findMedicamento/{codigo}")
	@ResponseBody
	public Medicamento findMedicamento(@PathVariable("codigo") int cod){
		return medicamentoService.findId(cod);
	}
	//insert
	@PostMapping(path = "/saveMedicamento")
	public void saveMedicamento(@RequestBody Medicamento bean) {
		medicamentoService.save(bean);
	}
	//update
	@PutMapping(path = "/updateMedicamento")
	public void updateMedicamento(@RequestBody Medicamento bean) {
		medicamentoService.update(bean);
	}	
	//delete
	@DeleteMapping(path = "/deleteMedicamento/{codigo}")
	public void deleteMedicamento(@PathVariable("codigo") int cod){
		medicamentoService.delete(cod);
	}
}
