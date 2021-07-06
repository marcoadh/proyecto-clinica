package net.spring.clinica.dao;
import java.util.List;

import net.spring.clinica.entity.Usuario;

public interface UsuarioDAO {
	public void save(Usuario bean);
	public void update(Usuario bean);
	public void delete(int cod);
	public Usuario findId(int cod);
	public List<Usuario> listAll();
}
