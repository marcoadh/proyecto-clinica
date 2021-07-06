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

import net.spring.clinica.entity.Distrito;
import net.spring.clinica.entity.Paciente;




@Controller
@RequestMapping(value = "/pacientes")
public class PacienteController {
	private String URL="http://localhost:8080/WS_Servidor/paciente";
	
	
	@RequestMapping(value = "/")
	public String principal(Model model) {
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Paciente[]>data= rt.getForEntity(URL+"/listAllPaciente", Paciente[].class);
		Paciente[] lista=data.getBody();
		model.addAttribute("dataPacientes",lista);
		return "paciente";
	}
	@RequestMapping(value = "/listaDistrito")
	@ResponseBody
	public Distrito[] listaDistrito(Model model) {
		Distrito[] lista=null;
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Distrito[]>data= rt.getForEntity(URL+"/listAllDistrito", Distrito[].class);
		lista=data.getBody();
		return lista;
	}

	@RequestMapping(value = "/buscar")
	@ResponseBody
	public Paciente buscar(@RequestParam("codigo") int cod) {
		Paciente lista=null;
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Paciente>data= rt.getForEntity(URL+"/findPaciente/"+cod, Paciente.class);
		lista=data.getBody();
		return lista;
	}	
	
	
	@RequestMapping(value = "/save")
	public String save(@RequestParam("codigo") int cod,
						@RequestParam("dni") String dni,
						@RequestParam("nombre") String nom,
						@RequestParam("apellido") String ape,
						@RequestParam("estado") String est,
						@RequestParam("telefono") String tlf,
						@RequestParam("direccion") String dir,
						@RequestParam("distrito") int codDis,
						RedirectAttributes redirect) {
		//crear objeto de la clase Computadora
		Paciente bean=new Paciente();
		bean.setCodigoPaciente(cod);
		bean.setDni(dni);
		bean.setNombre(nom);
		bean.setApellido(ape);
		bean.setEstado(est);
		bean.setTelefono(tlf);
		bean.setDireccion(dir);
		bean.setDistrito(new Distrito(codDis));
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
			rt.postForObject(URL+"/savePaciente", request, String.class);
			redirect.addFlashAttribute("MENSAJE","Registro correcto...");
		}
		else {
			//cabecera formato JSON
			HttpHeaders headers=new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			//unir json+headers
			HttpEntity<String> request=new HttpEntity<String>(json,headers);
			rt.put(URL+"/updatePaciente", request, String.class);
			redirect.addFlashAttribute("MENSAJE","Registro actualizado...");			
		}
		
		return "redirect:/pacientes/";
	}
	
	@RequestMapping(value = "/delete/{codigo}")
	public String delete(@PathVariable("codigo") int cod,
						RedirectAttributes redirect) {
		RestTemplate rt=new RestTemplate();
		try {
			rt.delete(URL+"/deletePaciente/"+cod);
			redirect.addFlashAttribute("MENSAJE","Registro eliminado...");
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE","Error en la eliminaciòn...");
		}
		return "redirect:/pacientes/";
	}
	
}






