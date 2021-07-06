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

import net.spring.clinica.entity.Medicamento;

@Controller
@RequestMapping(value = "/medicamentos")
public class MedicamentoController {
	
	private String URL="http://localhost:8080/WS_Servidor/medicamento";
	
	@RequestMapping(value = "/")
	public String principal(Model model) {
		//clase para llamar a un servicio 
		RestTemplate rt=new RestTemplate();
		//acceder a la anotaciòn GET del servicio usar el nombre "listAllComputadora"
		ResponseEntity<Medicamento[]>data= rt.getForEntity(URL+"/listAllMedicamento", Medicamento[].class);
		//obtener el JSOn que tiene data
		Medicamento[] lista=data.getBody();
		//crear un atrubuto
		model.addAttribute("dataMedicamentos",lista);
		return "medicamento";
	}
	
	@RequestMapping(value = "/buscar")
	@ResponseBody
	public Medicamento buscar(@RequestParam("codigo") int cod) {
		Medicamento lista=null;
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Medicamento>data= rt.getForEntity(URL+"/findMedicamento/"+cod, Medicamento.class);
		lista=data.getBody();
		return lista;
	}	
	
	@RequestMapping(value = "/save")
	public String save(@RequestParam("codigo") int cod,
			            @RequestParam("nombre") String nom,
						@RequestParam("concentracion") String con,
						@RequestParam("presentacion") String pre,		
						RedirectAttributes redirect) {
		//crear objeto de la clase Computadora
		Medicamento bean=new Medicamento();
		bean.setCodigoMedicamento(cod);
		bean.setNombre(nom);
		bean.setConcentracion(con);
		bean.setPresentacion(pre);
		
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
			rt.postForObject(URL+"/saveMedicamento", request, String.class);
			redirect.addFlashAttribute("MENSAJE","Registro correcto...");
		}
		else {
			//cabecera formato JSON
			HttpHeaders headers=new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			//unir json+headers
			HttpEntity<String> request=new HttpEntity<String>(json,headers);
			rt.put(URL+"/updateMedicamento", request, String.class);
			redirect.addFlashAttribute("MENSAJE","Registro actualizado...");			
		}		
		return "redirect:/medicamentos/";
	}
	@RequestMapping(value = "/delete/{codigo}")
	public String delete(@PathVariable("codigo") int cod,
						RedirectAttributes redirect) {
		RestTemplate rt=new RestTemplate();
		try {
			rt.delete(URL+"/deleteMedicamento/"+cod);
			redirect.addFlashAttribute("MENSAJE","Registro eliminado...");
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE","Error en la eliminaciòn...");
		}
		return "redirect:/medicamentos/";
	}
}
