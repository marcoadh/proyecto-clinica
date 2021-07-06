package net.spring.clinica.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.spring.clinica.entity.Empleado;


@Repository
public class EmpleadoDAOImpl implements EmpleadoDAO {

		@Autowired
		private SessionFactory factory;

		@Transactional
		@Override
		public void save(Empleado bean) {
			Session session=factory.getCurrentSession();
			try {
				session.save(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Transactional
		@Override
		public void update(Empleado bean) {
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
				Empleado bean=session.get(Empleado.class, cod);
				session.delete(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Transactional
		@Override
		public Empleado findId(int cod) {
			Empleado bean=null;
			Session session=factory.getCurrentSession();
			try {
				bean=session.get(Empleado.class, cod);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bean;
		}

		@Transactional(readOnly = true)
		@Override
		public List<Empleado> listAll() {
			List<Empleado> lista=null;
			Query query=null;
			Session session=factory.getCurrentSession();
			try {
				String hql="select e from Empleado e";
				query=session.createQuery(hql);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return query.getResultList();
		}
}
