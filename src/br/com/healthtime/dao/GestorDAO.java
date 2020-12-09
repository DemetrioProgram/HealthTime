package br.com.healthtime.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.healthtime.entity.Gestor;
import br.com.healthtime.util.HibernateUtil;

public class GestorDAO {
	
	public static Gestor doLogin(String cpf) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			Criteria query = session.createCriteria(Gestor.class);
			Gestor gestor = (Gestor) query.add(Restrictions.eq("cpf", cpf)).uniqueResult();

			System.out.println("Gestor" + gestor);

			transaction.commit();

			return gestor;

		} catch (Exception e) {
			System.out.println("Erro doLogin Gestor");
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
				
			}
		}
	}

}
