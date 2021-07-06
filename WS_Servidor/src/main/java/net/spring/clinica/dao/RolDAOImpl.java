package net.spring.clinica.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import net.spring.clinica.entity.Rol;

@Repository
public class RolDAOImpl implements RolDAO {

		@Autowired
		private SessionFactory factory;

		@Transactional
		@Override
		public void save(Rol bean) {
			Session session=factory.getCurrentSession();
			try {
				session.save(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Transactional
		@Override
		public void update(Rol bean) {
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
				Rol bean=session.get(Rol.class, cod);
				session.delete(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Transactional
		@Override
		public Rol findId(int cod) {
			Rol bean=null;
			Session session=factory.getCurrentSession();
			try {
				bean=session.get(Rol.class, cod);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bean;
		}

		@Transactional(readOnly = true)
		@Override
		public List<Rol> listAll() {
			List<Rol> lista=null;
			Query query=null;
			Session session=factory.getCurrentSession();
			try {
				String hql="select r from Rol r";
				query=session.createQuery(hql);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return query.getResultList();
		}
}
