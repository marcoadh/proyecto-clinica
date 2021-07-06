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

import net.spring.clinica.entity.Rol;
import net.spring.clinica.service.RolService;

@RestController
@RequestMapping(value = "/rol")
public class RolController {

	@Autowired
	private RolService rolService;

	@GetMapping(path = "/listAllRol")
	@ResponseBody
	public List<Rol> listAllRol(){
		return rolService.listAll();
	}	
	
	@GetMapping(path = "/findRol/{codigo}")
	@ResponseBody
	public Rol findRol(@PathVariable("codigo") int cod){
		return rolService.findId(cod);
	}
	//insert
	@PostMapping(path = "/saveRol")
	public void saveRol(@RequestBody Rol bean) {
		rolService.save(bean);
	}
	//update
	@PutMapping(path = "/updateRol")
	public void updateRol(@RequestBody Rol bean) {
		rolService.update(bean);
	}	
	//delete
	@DeleteMapping(path = "/deleteRol/{codigo}")
	public void deleteRol(@PathVariable("codigo") int cod){
		rolService.delete(cod);
	}
}
