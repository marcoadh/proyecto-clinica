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
import net.spring.clinica.service.DistritoService;



@RestController
@RequestMapping(value = "/distrito")
public class DistritoController {

	@Autowired
	private DistritoService distritoService;

	@GetMapping(path = "/listAllDistrito")
	@ResponseBody
	public List<Distrito> listAllDistrito(){
		return distritoService.listAll();
	}	
	
	@GetMapping(path = "/findDistrito/{codigo}")
	@ResponseBody
	public Distrito findDistrito(@PathVariable("codigo") int cod){
		return distritoService.findId(cod);
	}
	//insert
	@PostMapping(path = "/saveDistrito")
	public void saveDistrito(@RequestBody Distrito bean) {
		distritoService.save(bean);
	}
	//update
	@PutMapping(path = "/updateDistrito")
	public void updateDistrito(@RequestBody Distrito bean) {
		distritoService.update(bean);
	}	
	//delete
	@DeleteMapping(path = "/deleteDistrito/{codigo}")
	public void deleteDistrito(@PathVariable("codigo") int cod){
		distritoService.delete(cod);
	}
}
