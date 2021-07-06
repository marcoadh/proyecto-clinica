package net.spring.clinica.controller;

import java.util.Date;

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

import net.spring.clinica.entity.Cita;
import net.spring.clinica.entity.Empleado;
import net.spring.clinica.entity.Paciente;

@Controller
@RequestMapping(value = "/citas")
public class CitaController {
	
	private String URL="http://localhost:8080/WS_Servidor/cita";
	
	@RequestMapping(value = "/")
	public String principal(Model model) {
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Cita[]>data= rt.getForEntity(URL+"/listAllCita", Cita[].class);
		Cita[] lista=data.getBody();
		model.addAttribute("dataCitas",lista);
		return "cita";
	}
	
	@RequestMapping(value = "/listaPaciente")
	@ResponseBody
	public Paciente[] listaPaciente(Model model) {
		Paciente[] lista=null;
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Paciente[]>data= rt.getForEntity(URL+"/listAllPaciente", Paciente[].class);
		lista=data.getBody();
		return lista;
	}
	
	
	@RequestMapping(value = "/buscar")
	@ResponseBody
	public Cita buscar(@RequestParam("codigo") int cod) {
		Cita lista=null;
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Cita>data= rt.getForEntity(URL+"/findCita/"+cod, Cita.class);
		lista=data.getBody();
		return lista;
	}	
	
	
	@RequestMapping(value = "/save")
	public String save(@RequestParam("codigo") int cod,
						@RequestParam("asunto") String asu,
						@RequestParam("enfermedad") String enf,
						@RequestParam("sintomas") String sint,
						@RequestParam("fechaRegistro") String fecha,
						@RequestParam("paciente") int codPac,
						RedirectAttributes redirect) {
		//crear objeto de la clase Computadora
		Cita bean=new Cita();
		bean.setCodigoCita(cod);
		bean.setAsunto(asu);
		bean.setEnfermedad(enf);
		bean.setSintomas(sint);
		bean.setFechaRegistro(fecha);
		bean.setPaciente(new Paciente(codPac));
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
			rt.postForObject(URL+"/saveCita", request, String.class);
			redirect.addFlashAttribute("MENSAJE","Registro correcto...");
		}
		else {
			//cabecera formato JSON
			HttpHeaders headers=new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			//unir json+headers
			HttpEntity<String> request=new HttpEntity<String>(json,headers);
			rt.put(URL+"/updateCita", request, String.class);
			redirect.addFlashAttribute("MENSAJE","Registro actualizado...");			
		}		
	return "redirect:/citas/";
	}
	@RequestMapping(value = "/delete/{codigo}")
	public String delete(@PathVariable("codigo") int cod,
						RedirectAttributes redirect) {
		RestTemplate rt=new RestTemplate();
		try {
			rt.delete(URL+"/deleteCita/"+cod);
			redirect.addFlashAttribute("MENSAJE","Registro eliminado...");
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE","Error en la eliminaciòn...");
		}
		return "redirect:/citas/";
	}
}
