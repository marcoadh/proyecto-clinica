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
import net.spring.clinica.service.TipoEmpleadoService;

@RestController
@RequestMapping(value = "/tipoempleado")
public class TipoEmpleadoController {

	@Autowired
	private TipoEmpleadoService tipoempleadoService;

	@GetMapping(path = "/listAllTipoEmpleado")
	@ResponseBody
	public List<TipoEmpleado> listAllTipoEmpleado(){
		return tipoempleadoService.listAll();
	}	
	
	@GetMapping(path = "/findTipoEmpleado/{codigo}")
	@ResponseBody
	public TipoEmpleado findTipoEmpleado(@PathVariable("codigo") int cod){
		return tipoempleadoService.findId(cod);
	}
	//insert
	@PostMapping(path = "/saveTipoEmpleado")
	public void saveTipoEmpleado(@RequestBody TipoEmpleado bean) {
		tipoempleadoService.save(bean);
	}
	//update
	@PutMapping(path = "/updateTipoEmpleado")
	public void updateTipoEmpleado(@RequestBody TipoEmpleado bean) {
		tipoempleadoService.update(bean);
	}	
	//delete
	@DeleteMapping(path = "/deleteTipoEmpleado/{codigo}")
	public void deleteTipoEmpleado(@PathVariable("codigo") int cod){
		tipoempleadoService.delete(cod);
	}
}
