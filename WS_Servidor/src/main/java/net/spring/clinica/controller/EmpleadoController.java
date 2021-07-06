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

import net.spring.clinica.entity.TipoEmpleado;
import net.spring.clinica.entity.Empleado;
import net.spring.clinica.service.TipoEmpleadoService;
import net.spring.clinica.service.EmpleadoService;

@RestController
@RequestMapping(value = "/empleado")
public class EmpleadoController {


	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private TipoEmpleadoService tipoEmpleadoService;

	//select marca > a una fila
	@GetMapping(path = "/listAllTipoEmpleado")
	@ResponseBody
	public List<TipoEmpleado> listAllTipoEmpleado(){
		return tipoEmpleadoService.listAll();
	}
	
	@GetMapping(path = "/listAllEmpleado")
	@ResponseBody
	public List<Empleado> listAllEmpleado(){
		return empleadoService.listAll();
	}	
	
	@GetMapping(path = "/findEmpleado/{codigo}")
	@ResponseBody
	public Empleado findEmpleado(@PathVariable("codigo") int cod){
		return empleadoService.findId(cod);
	}
	//insert
	@PostMapping(path = "/saveEmpleado")
	public void saveEmpleado(@RequestBody Empleado bean) {
		empleadoService.save(bean);
	}
	//update
	@PutMapping(path = "/updateEmpleado")
	public void updateEmpleado(@RequestBody Empleado bean) {
		empleadoService.update(bean);
	}	
	//delete
	@DeleteMapping(path = "/deleteEmpleado/{codigo}")
	public void deleteEmpleado(@PathVariable("codigo") int cod){
		empleadoService.delete(cod);
	}
}
