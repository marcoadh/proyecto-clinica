package net.spring.clinica.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import net.spring.clinica.entity.TipoEmpleado;

@Repository
public class TipoEmpleadoDAOImpl implements TipoEmpleadoDAO {

		@Autowired
		private SessionFactory factory;

		@Transactional
		@Override
		public void save(TipoEmpleado bean) {
			Session session=factory.getCurrentSession();
			try {
				session.save(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Transactional
		@Override
		public void update(TipoEmpleado bean) {
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
				TipoEmpleado bean=session.get(TipoEmpleado.class, cod);
				session.delete(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Transactional
		@Override
		public TipoEmpleado findId(int cod) {
			TipoEmpleado bean=null;
			Session session=factory.getCurrentSession();
			try {
				bean=session.get(TipoEmpleado.class, cod);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bean;
		}

		@Transactional(readOnly = true)
		@Override
		public List<TipoEmpleado> listAll() {
			List<TipoEmpleado> lista=null;
			Query query=null;
			Session session=factory.getCurrentSession();
			try {
				String hql="select e from TipoEmpleado e";
				query=session.createQuery(hql);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return query.getResultList();
		}
}
