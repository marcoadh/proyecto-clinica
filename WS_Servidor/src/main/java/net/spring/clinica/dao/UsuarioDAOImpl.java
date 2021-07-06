package net.spring.clinica.dao;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.spring.clinica.entity.Usuario;
@Repository
public class UsuarioDAOImpl implements UsuarioDAO{
	@Autowired
	private SessionFactory factory;
	
	
	
	
	

	@Transactional
	@Override
	public void save(Usuario bean) {
		Session session=factory.getCurrentSession();
		try {
			session.save(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void update(Usuario bean) {
		Session session=factory.getCurrentSession();
		try {
			session.update(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void delete(int cod) {
		Session session=factory.getCurrentSession();
		try {
			Usuario bean=session.get(Usuario.class, cod);
			session.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public Usuario findId(int cod) {
		Usuario bean=null;
		Session session=factory.getCurrentSession();
		try {
			bean=session.get(Usuario.class, cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Usuario> listAll() {
		List<Usuario> lista=null;
		Query query=null;
		Session session=factory.getCurrentSession();
		try {
			String hql="select u from Usuario u";
			query=session.createQuery(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

}
