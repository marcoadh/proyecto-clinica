package net.spring.clinica.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import net.spring.clinica.entity.Paciente;

@Repository
public class PacienteDAOImpl implements PacienteDAO {

		@Autowired
		private SessionFactory factory;

		@Transactional
		@Override
		public void save(Paciente bean) {
			Session session=factory.getCurrentSession();
			try {
				session.save(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Transactional
		@Override
		public void update(Paciente bean) {
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
				Paciente bean=session.get(Paciente.class, cod);
				session.delete(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Transactional
		@Override
		public Paciente findId(int cod) {
			Paciente bean=null;
			Session session=factory.getCurrentSession();
			try {
				bean=session.get(Paciente.class, cod);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bean;
		}

		@Transactional(readOnly = true)
		@Override
		public List<Paciente> listAll() {
			List<Paciente> lista=null;
			Query query=null;
			Session session=factory.getCurrentSession();
			try {
				String hql="select c from Paciente c";
				query=session.createQuery(hql);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return query.getResultList();
		}
}
