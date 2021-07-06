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

import net.spring.clinica.entity.Distrito;
import net.spring.clinica.entity.Paciente;
import net.spring.clinica.service.DistritoService;
import net.spring.clinica.service.PacienteService;

@RestController
@RequestMapping(value = "/paciente")
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private DistritoService distritoService;
	
	

	//select marca > a una fila
	@GetMapping(path = "/listAllDistrito")
	@ResponseBody
	public List<Distrito> listAllDistrito(){
		return distritoService.listAll();
	}
	
	
	
	@GetMapping(path = "/listAllPaciente")
	@ResponseBody
	public List<Paciente> listAllPaciente(){
		return pacienteService.listAll();
	}	
	
	@GetMapping(path = "/findPaciente/{codigo}")
	@ResponseBody
	public Paciente findPaciente(@PathVariable("codigo") int cod){
		return pacienteService.findId(cod);
	}
	//insert
	@PostMapping(path = "/savePaciente")
	public void savePaciente(@RequestBody Paciente bean) {
		pacienteService.save(bean);
	}
	//update
	@PutMapping(path = "/updatePaciente")
	public void updatePaciente(@RequestBody Paciente bean) {
		pacienteService.update(bean);
	}	
	//delete
	@DeleteMapping(path = "/deletePaciente/{codigo}")
	public void deletePaciente(@PathVariable("codigo") int cod){
		pacienteService.delete(cod);
	}
}
