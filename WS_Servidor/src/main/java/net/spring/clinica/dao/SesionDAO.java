package net.spring.clinica.dao;
import java.util.List;

import net.spring.clinica.entity.Enlace;
import net.spring.clinica.entity.Usuario;

public interface SesionDAO {	
	public Usuario iniciaSesion(String login, String clave);
	public List<Enlace> traerPrivilegios(int rol);
}
