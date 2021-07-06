package net.spring.clinica.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.spring.clinica.entity.Cita;

@Repository
public class CitaDAOImpl implements CitaDAO {
	@Autowired
	private SessionFactory factory;

	@Transactional
	@Override
	public void save(Cita bean) {
		Session session=factory.getCurrentSession();
		try {
			session.save(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void update(Cita bean) {
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
			Cita bean=session.get(Cita.class, cod);
			session.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public Cita findId(int cod) {
		Cita bean=null;
		Session session=factory.getCurrentSession();
		try {
			bean=session.get(Cita.class, cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Cita> listAll() {
		List<Cita> lista=null;
		Query query=null;
		Session session=factory.getCurrentSession();
		try {
			String hql="select t from Cita t";
			query=session.createQuery(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

}
