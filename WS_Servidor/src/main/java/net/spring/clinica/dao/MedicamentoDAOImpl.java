package net.spring.clinica.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.spring.clinica.entity.Medicamento;

@Repository
public class MedicamentoDAOImpl implements MedicamentoDAO {

		@Autowired
		private SessionFactory factory;

		@Transactional
		@Override
		public void save(Medicamento bean) {
			Session session=factory.getCurrentSession();
			try {
				session.save(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Transactional
		@Override
		public void update(Medicamento bean) {
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
				Medicamento bean=session.get(Medicamento.class, cod);
				session.delete(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Transactional
		@Override
		public Medicamento findId(int cod) {
			Medicamento bean=null;
			Session session=factory.getCurrentSession();
			try {
				bean=session.get(Medicamento.class, cod);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bean;
		}

		@Transactional(readOnly = true)
		@Override
		public List<Medicamento> listAll() {
			List<Medicamento> lista=null;
			Query query=null;
			Session session=factory.getCurrentSession();
			try {
				String hql="select m from Medicamento m";
				query=session.createQuery(hql);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return query.getResultList();
		}
}
