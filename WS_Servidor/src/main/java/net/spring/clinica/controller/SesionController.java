package net.spring.clinica.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.spring.clinica.entity.Enlace;
import net.spring.clinica.entity.Usuario;
import net.spring.clinica.service.SesionService;
@RestController
@RequestMapping(value = "/session")
public class SesionController {
	
	@Autowired
	private SesionService usuarioService;
	
	
	@GetMapping(path = "/iniciar/{login}/{clave}")
	@ResponseBody
	public Usuario iniciar(@PathVariable("login") String vLogin,
							@PathVariable("clave") String vClave) {
		Usuario bean=null;
		bean=usuarioService.iniciaSesion(vLogin, vClave);
		return bean;
	}
	
	/*@GetMapping(path = "/privilegios/{rol}")
	@ResponseBody
	public List<Enlace> privilegios(@PathVariable("rol")int rol ){
			List<Enlace> lista=usuarioService.traerPrivilegios(rol);
			return lista;
	}*/
	//anotaciòn para tabajar con select -->retorna una lista Enlace
	@GetMapping(path = "/privilegios/{rol}")
	@ResponseBody
	public List<Enlace> privilegios(@PathVariable("rol") int vRol){
			List<Enlace> lista=usuarioService.traerPrivilegios(vRol);
			return lista;
	}

}
