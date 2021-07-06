package net.spring.clinica.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.spring.clinica.dao.UsuarioDAO;
import net.spring.clinica.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public void save(Usuario bean) {
		usuarioDAO.save(bean);
	}

	@Override
	public void update(Usuario bean) {
		usuarioDAO.update(bean);
	}

	@Override
	public void delete(int cod) {
		usuarioDAO.delete(cod);
	}

	@Override
	public Usuario findId(int cod) {
		// TODO Auto-generated method stub
		return usuarioDAO.findId(cod);
	}

	@Override
	public List<Usuario> listAll() {
		// TODO Auto-generated method stub
		return usuarioDAO.listAll();
	}

}
