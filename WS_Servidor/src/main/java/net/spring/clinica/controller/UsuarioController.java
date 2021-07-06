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

import net.spring.clinica.entity.Empleado;
import net.spring.clinica.entity.Rol;
import net.spring.clinica.entity.Usuario;
import net.spring.clinica.service.EmpleadoService;
import net.spring.clinica.service.RolService;
import net.spring.clinica.service.UsuarioService;
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RolService rolService;
	
	@Autowired
	private EmpleadoService empleadoService;


	
	@GetMapping(path = "/listAllRol")
	@ResponseBody
	public List<Rol> listAllRol(){
		return rolService.listAll();
	}
	
	@GetMapping(path = "/listAllEmpleado")
	@ResponseBody
	public List<Empleado> listAllEmpleado(){
		return empleadoService.listAll();
	}
	
	@GetMapping(path = "/listAllUsuario")
	@ResponseBody
	public List<Usuario> listAllUsuario(){
		return usuarioService.listAll();
	}	
	
	
	
	@GetMapping(path = "/findUsuario/{codigo}")
	@ResponseBody
	public Usuario findUsuario(@PathVariable("codigo") int cod){
		return usuarioService.findId(cod);
	}
	//insert
	@PostMapping(path = "/saveUsuario")
	public void saveUsuario(@RequestBody Usuario bean) {
		usuarioService.save(bean);
	}
	//update
	@PutMapping(path = "/updateUsuario")
	public void updateUsuario(@RequestBody Usuario bean) {
		usuarioService.update(bean);
	}	
	//delete
	@DeleteMapping(path = "/deleteUsuario/{codigo}")
	public void deleteUsuario(@PathVariable("codigo") int cod){
		usuarioService.delete(cod);
	}
	
}
