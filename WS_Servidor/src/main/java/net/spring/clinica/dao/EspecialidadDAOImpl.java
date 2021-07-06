package net.spring.clinica.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.spring.clinica.entity.Especialidad;

@Repository
public class EspecialidadDAOImpl implements EspecialidadDAO {

		@Autowired
		private SessionFactory factory;

		@Transactional
		@Override
		public void save(Especialidad bean) {
			Session session=factory.getCurrentSession();
			try {
				session.save(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Transactional
		@Override
		public void update(Especialidad bean) {
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
				Especialidad bean=session.get(Especialidad.class, cod);
				session.delete(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Transactional
		@Override
		public Especialidad findId(int cod) {
			Especialidad bean=null;
			Session session=factory.getCurrentSession();
			try {
				bean=session.get(Especialidad.class, cod);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bean;
		}

		@Transactional(readOnly = true)
		@Override
		public List<Especialidad> listAll() {
			List<Especialidad> lista=null;
			Query query=null;
			Session session=factory.getCurrentSession();
			try {
				String hql="select e from Especialidad e";
				query=session.createQuery(hql);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return query.getResultList();
		}
}
