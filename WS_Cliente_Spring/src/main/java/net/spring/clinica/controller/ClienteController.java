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
import net.spring.clinica.entity.Cliente;

@Controller
@RequestMapping(value="/clientes")
public class ClienteController {
	
	//private String URL="http://localhost:8080/P_Servidor_REST/cliente";
	private String URL="http://localhost:8080/WS_Servidor/cliente";
	
	@RequestMapping(value = "/")
	public String principal(Model model) {
		//clase para llamar a un servicio 
		RestTemplate rt=new RestTemplate();
		//acceder a la anotaciòn GET del servicio usar el nombre "listAllComputadora"
		ResponseEntity<Cliente[]>data= rt.getForEntity(URL+"/listAllCliente", Cliente[].class);
		//obtener el JSOn que tiene data
		Cliente[] lista=data.getBody();
		//crear un atrubuto
		model.addAttribute("dataClientes",lista);
		return "cliente";
	}
	
	@RequestMapping(value = "/buscar")
	@ResponseBody
	public Cliente buscar(@RequestParam("codigo") int cod) {
		Cliente lista=null;
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Cliente>data= rt.getForEntity(URL+"/findCliente/"+cod, Cliente.class);
		lista=data.getBody();
		return lista;
	}	
	
	@RequestMapping(value = "/save")
	public String save(@RequestParam("codigo") int cod,
						@RequestParam("dni") String dni,
			            @RequestParam("nombre") String nom,
						@RequestParam("apellido") String ape,
						@RequestParam("estado") String est,
						@RequestParam("telefono") String tel,
						@RequestParam("direccion") String dir,
						RedirectAttributes redirect) {
		//crear objeto de la clase Computadora
		Cliente bean=new Cliente();
		bean.setCodigoCliente(cod);
		bean.setDni(dni);
		bean.setNombre(nom);
		bean.setApellido(ape);
		bean.setEstado(est);
		bean.setTelefono(tel);
		bean.setDireccion(dir);
			
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
			rt.postForObject(URL+"/saveCliente", request, String.class);
			redirect.addFlashAttribute("MENSAJE","Registro correcto...");
		}
		else {
			//cabecera formato JSON
			HttpHeaders headers=new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			//unir json+headers
			HttpEntity<String> request=new HttpEntity<String>(json,headers);
			rt.put(URL+"/updateCliente", request, String.class);
			redirect.addFlashAttribute("MENSAJE","Registro actualizado...");			
		}		
	return "redirect:/clientes/";
}
	@RequestMapping(value = "/delete/{codigo}")
	public String delete(@PathVariable("codigo") int cod,
						RedirectAttributes redirect) {
		RestTemplate rt=new RestTemplate();
		try {
			rt.delete(URL+"/deleteCliente/"+cod);
			redirect.addFlashAttribute("MENSAJE","Registro eliminado...");
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE","Error en la eliminaciòn...");
		}
		return "redirect:/clientes/";
	}
	}
