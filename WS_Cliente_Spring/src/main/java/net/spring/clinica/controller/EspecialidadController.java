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

import net.spring.clinica.entity.Especialidad;



@Controller
@RequestMapping(value = "/especialidades")
public class EspecialidadController {
	
	private String URL="http://localhost:8080/WS_Servidor/especialidad";
	
	@RequestMapping(value = "/")
	public String principal(Model model) {
		//clase para llamar a un servicio 
		RestTemplate rt=new RestTemplate();
		
		//acceder a la anotaciòn GET del servicio usar el nombre "listAllComputadora"
		ResponseEntity<Especialidad[]>data= rt.getForEntity(URL+"/listAllEspecialidad", Especialidad[].class);
		
		//obtener el JSOn que tiene data
		Especialidad[] lista=data.getBody();
		
		//crear un atrubuto
		model.addAttribute("dataEspecialidades",lista);
		return "especialidad";
	}
	
	@RequestMapping(value = "/buscar")
	@ResponseBody
	public Especialidad buscar(@RequestParam("codigo") int cod) {
		Especialidad lista=null;
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Especialidad>data= rt.getForEntity(URL+"/findEspecialidad/"+cod, Especialidad.class);
		lista=data.getBody();
		return lista;
	}	
	
	@RequestMapping(value = "/save")
	public String save(@RequestParam("codigo") int cod,
			            @RequestParam("nombre") String nom,	
						RedirectAttributes redirect) {
		//crear objeto de la clase Computadora
		Especialidad bean=new Especialidad();
		bean.setCodigoEspecialidad(cod);
		bean.setNombre(nom);
		
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
			rt.postForObject(URL+"/saveEspecialidad", request, String.class);
			redirect.addFlashAttribute("MENSAJE","Registro correcto...");
		}
		else {
			//cabecera formato JSON
			HttpHeaders headers=new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			//unir json+headers
			HttpEntity<String> request=new HttpEntity<String>(json,headers);
			rt.put(URL+"/updateEspecialidad", request, String.class);
			redirect.addFlashAttribute("MENSAJE","Registro actualizado...");			
		}		
		return "redirect:/especialidades/";
	}
	@RequestMapping(value = "/delete/{codigo}")
	public String delete(@PathVariable("codigo") int cod,
						RedirectAttributes redirect) {
		RestTemplate rt=new RestTemplate();
		try {
			rt.delete(URL+"/deleteEspecialidad/"+cod);
			redirect.addFlashAttribute("MENSAJE","Registro eliminado...");
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE","Error en la eliminaciòn...");
		}
		return "redirect:/especialidades/";
	}
}
