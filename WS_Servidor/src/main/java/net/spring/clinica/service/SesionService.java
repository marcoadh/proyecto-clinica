package net.spring.clinica.service;
import java.util.List;
import net.spring.clinica.entity.Enlace;
import net.spring.clinica.entity.Usuario;

public interface SesionService {
	public Usuario iniciaSesion(String login, String clave);
	public List<Enlace> traerPrivilegios(int rol);
}
