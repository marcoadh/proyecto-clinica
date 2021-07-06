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

import net.spring.clinica.entity.Especialidad;
import net.spring.clinica.service.EspecialidadService;

@RestController
@RequestMapping(value = "/especialidad")
public class EspecialidadController {

	@Autowired
	private EspecialidadService especialidadService;

	@GetMapping(path = "/listAllEspecialidad")
	@ResponseBody
	public List<Especialidad> listAllEspecialidad(){
		return especialidadService.listAll();
	}	
	
	@GetMapping(path = "/findEspecialidad/{codigo}")
	@ResponseBody
	public Especialidad findEspecialidad(@PathVariable("codigo") int cod){
		return especialidadService.findId(cod);
	}
	//insert
	@PostMapping(path = "/saveEspecialidad")
	public void saveEspecialidad(@RequestBody Especialidad bean) {
		especialidadService.save(bean);
	}
	//update
	@PutMapping(path = "/updateEspecialidad")
	public void updateEspecialidad(@RequestBody Especialidad bean) {
		especialidadService.update(bean);
	}	
	//delete
	@DeleteMapping(path = "/deleteEspecialidad/{codigo}")
	public void deleteEspecialidad(@PathVariable("codigo") int cod){
		especialidadService.delete(cod);
	}
}
