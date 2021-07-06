package net.spring.clinica.dao;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.spring.clinica.entity.Empleado;
import net.spring.clinica.entity.Enlace;
import net.spring.clinica.entity.Usuario;
@Repository
public class SesionDAOImpl implements SesionDAO{
	@Autowired
	private SessionFactory factory;
	
	
	@Transactional(readOnly=true)
	@Override
	public Usuario iniciaSesion(String login, String clave) {
		Session session=factory.getCurrentSession();
		Usuario bean=null;
		Query query;
		try {
			String hql="select u from Usuario u where u.login=?1 and u.password=?2";
			query=session.createQuery(hql);
			query.setParameter(1, login);
			query.setParameter(2, clave);
			List<Empleado> lista=query.getResultList();
			//validar
			if(!lista.isEmpty())
				bean=(Usuario) query.getSingleResult();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bean;
	}
	/*@Transactional(readOnly=true)
	@Override
	public List<Enlace> traerPrivilegios(int rol) {
		Session session=factory.getCurrentSession();
		List<Enlace> lista=null;
		Query query;
		try {
			//String hql="select e from RolEnlace re join re.enlace e join re.rol r "+
			//				"where re.rol.idrol=?1";
			String hql="select e from RolEnlace re join re.enlace e "+
					"join re.rol where re.rol.idrol=?1";
			
			
			query=session.createQuery(hql);
			query.setParameter(1,rol);
			lista=query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}*/
	@Transactional(readOnly=true)
	@Override
	public List<Enlace> traerPrivilegios(int rol) {
		Session session=factory.getCurrentSession();
		List<Enlace> lista=null;
		Query query=null;
		try {
			String hql="select e from RolEnlace re join re.enlace e "+
						"join re.rol where re.rol.idRol=?1";
			query=session.createQuery(hql);
			query.setParameter(1, rol);
			lista=query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
