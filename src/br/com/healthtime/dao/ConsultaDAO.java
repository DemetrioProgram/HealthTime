package br.com.healthtime.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.healthtime.entity.Consulta;
import br.com.healthtime.util.HibernateUtil;

public class ConsultaDAO {

	public void salvarConsulta(Consulta consulta) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			System.out.println("consulta " + consulta);
			session.save(consulta);

			transaction.commit();

		} catch (Exception e) {
			System.out.println("Erro salvaConsulta");
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.flush ();
			    session.clear ();
				session.close();
			}
		}
	}
		
	

}
