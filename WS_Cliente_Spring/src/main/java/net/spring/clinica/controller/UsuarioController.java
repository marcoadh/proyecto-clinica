package net.spring.clinica.controller;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

import net.spring.clinica.entity.Usuario;
import net.spring.clinica.entity.Empleado;
import net.spring.clinica.entity.Rol;


@Controller
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	private String URL="http://localhost:8080/WS_Servidor/usuario";
	
	
	@RequestMapping(value = "/")
	public String principal(Model model) {
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Usuario[]>data= rt.getForEntity(URL+"/listAllUsuario", Usuario[].class);
		Usuario[] lista=data.getBody();
		model.addAttribute("dataUsuarios",lista);
		return "usuario";
	}
	
	
	
	@RequestMapping(value = "/listaRol")
	@ResponseBody
	public Rol[] listaRol(Model model) {
		Rol[] lista=null;
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Rol[]>data= rt.getForEntity(URL+"/listAllRol", Rol[].class);
		lista=data.getBody();
		return lista;
	}
	
	
	
	@RequestMapping(value = "/listaEmpleado")
	@ResponseBody
	public Empleado[] listaTipoUsuario(Model model) {
		Empleado[] lista=null;
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Empleado[]>data= rt.getForEntity(URL+"/listAllEmpleado", Empleado[].class);
		lista=data.getBody();
		return lista;
	}

	@RequestMapping(value = "/buscar")
	@ResponseBody
	public Usuario buscar(@RequestParam("codigo") int cod) {
		Usuario lista=null;
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Usuario>data= rt.getForEntity(URL+"/findUsuario/"+cod, Usuario.class);
		lista=data.getBody();
		return lista;
	}	
	
	
	@RequestMapping(value = "/save")
	public String save(@RequestParam("codigo") int cod,
						@RequestParam("login") String login,
						@RequestParam("password") String pass,
						@RequestParam("rol") int codRol,
						@RequestParam("empleado") int codEmp,
						RedirectAttributes redirect) {
		//crear objeto de la clase Computadora
		Usuario bean=new Usuario();
		bean.setCodUsuario(cod);
		bean.setLogin(login);
		bean.setPassword(pass);
		bean.setRol(new Rol(codRol));
		bean.setEmpleado(new Empleado(codEmp));
		//serializar
		Gson gson=new Gson();
		String json=gson.toJson(bean);
		//
		RestTemplate rt=new RestTemplate();
		//validar cod
		if(cod==0) {
			//cabecera formato JSON
			HttpHeaders headers=new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			//unir json+headers
			HttpEntity<String> request=new HttpEntity<String>(json,headers);
			rt.postForObject(URL+"/saveUsuario", request, String.class);
			redirect.addFlashAttribute("MENSAJE","Registro correcto...");
		}
		else {
			//cabecera formato JSON
			HttpHeaders headers=new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			//unir json+headers
			HttpEntity<String> request=new HttpEntity<String>(json,headers);
			rt.put(URL+"/updateUsuario", request, String.class);
			redirect.addFlashAttribute("MENSAJE","Registro actualizado...");			
		}
		
		return "redirect:/usuarios/";
	}
	
	@RequestMapping(value = "/delete/{codigo}")
	public String delete(@PathVariable("codigo") int cod,
						RedirectAttributes redirect) {
		RestTemplate rt=new RestTemplate();
		try {
			rt.delete(URL+"/deleteUsuario/"+cod);
			redirect.addFlashAttribute("MENSAJE","Registro eliminado...");
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE","Error en la eliminaciòn...");
		}
		return "redirect:/usuarios/";
	}
	
}






