package net.spring.clinica.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.spring.clinica.dao.SesionDAO;
import net.spring.clinica.entity.Enlace;
import net.spring.clinica.entity.Usuario;

@Service
public class SesionServiceImpl implements SesionService{
	@Autowired
	private SesionDAO usuarioDAO;
	
	@Override
	public Usuario iniciaSesion(String login, String clave) {
		return usuarioDAO.iniciaSesion(login, clave);
	}

	@Override
	public List<Enlace> traerPrivilegios(int rol) {
		return usuarioDAO.traerPrivilegios(rol);
	}

}
