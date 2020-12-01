package br.com.healthtime.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.com.healthtime.entity.Consulta;
import br.com.healthtime.entity.Usuario;
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
				
				session.close();
			}
		}
	}

	public static List<Consulta> listarConsultas(int cdMedico, int cdUnidade) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			TypedQuery<Consulta> findAllQuery = session.createQuery("from Consulta where cdMedico=" +cdMedico + " and cdUnidade=" +cdUnidade, Consulta.class);	
						
			
			List<Consulta> consultas = findAllQuery.getResultList();

			System.out.println("Consultas" + consultas.size());

			transaction.commit();
			
			if (consultas.size() > 0) {
				return consultas;
			}
			else {
				return null;
			}

		} catch (Exception e) {
			System.out.println("Erro Listar Consultas");
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				
				session.close();
			}
		}
	}
		
	

}
