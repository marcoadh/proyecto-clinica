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

import net.spring.clinica.entity.Cita;
import net.spring.clinica.entity.Paciente;
import net.spring.clinica.service.CitaService;
import net.spring.clinica.service.PacienteService;

@RestController
@RequestMapping(value = "/cita")
public class CitaController {

	@Autowired
	private CitaService citaService;

	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping(path = "/listAllPaciente")
	@ResponseBody
	public List<Paciente> listAllPaciente(){
		return pacienteService.listAll();
	}	
	
	@GetMapping(path = "/listAllCita")
	@ResponseBody
	public List<Cita> listAllCita(){
		return citaService.listAll();
	}	
	
	@GetMapping(path = "/findCita/{codigo}")
	@ResponseBody
	public Cita findCita(@PathVariable("codigo") int cod){
		return citaService.findId(cod);
	}
	//insert
	@PostMapping(path = "/saveCita")
	public void saveCita(@RequestBody Cita bean) {
		citaService.save(bean);
	}
	//update
	@PutMapping(path = "/updateCita")
	public void updateCita(@RequestBody Cita bean) {
		citaService.update(bean);
	}	
	//delete
	@DeleteMapping(path = "/deleteCita/{codigo}")
	public void deleteCita(@PathVariable("codigo") int cod){
		citaService.delete(cod);
	}
}
