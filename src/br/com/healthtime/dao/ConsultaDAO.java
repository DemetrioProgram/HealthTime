package br.com.healthtime.dao;

import java.time.LocalDate;
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

	public static List<Consulta> listarConsutas(LocalDate  dtConsulta) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			TypedQuery<Consulta> findAllQuery = session.createQuery("from Consulta where cdpaciente is null and data=" + "'"+dtConsulta+"' " + 
			"group by horario", Consulta.class);	
						
			
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

	public static Consulta agendarConsulta(Consulta consultaAgendada) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();

			session.update(consultaAgendada);

			transaction.commit();

			return consultaAgendada;

		} catch (Exception e) {
			System.out.println("Erro Agendar Consulta");
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public static Consulta obterConsulta(int idConsulta) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();	
			
			TypedQuery<Consulta> findAllQuery = session.createQuery("from Consulta where cdConsulta="+idConsulta, Consulta.class);	
			
			
			
			Consulta consulta = findAllQuery.getSingleResult();

			System.out.println("Consulta" + consulta);

			transaction.commit();

			return consulta;

		} catch (Exception e) {
			System.out.println("Erro doObterConsulta");
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				//session.flush ();
			    //session.clear ();
				session.close();
				
			}
		}
	}

	public static Consulta obterConsulta(LocalDate dtConsulta, int cdUsuario) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();	
			
			TypedQuery<Consulta> findAllQuery = session.createQuery("from Consulta where cdPaciente="+cdUsuario
					+" and data="+ "'"+dtConsulta+"'", Consulta.class);	
			
			
			
			Consulta consulta = findAllQuery.getSingleResult();

			System.out.println("Consulta" + consulta);

			transaction.commit();

			return consulta;

		} catch (Exception e) {
			System.out.println("Erro doObterConsulta");
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				//session.flush ();
			    //session.clear ();
				session.close();
			}
		}
	}

	public static Consulta recuperarConsulta(LocalDate dtConsulta, int cdUsuario, String horario) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();	
			System.out.println("cdUsuario: "+ cdUsuario);
			
			TypedQuery<Consulta> findAllQuery = session.createQuery("from Consulta where cdMedico="+cdUsuario
					+" and data="+ "'"+dtConsulta+"' and horario='" + horario +"'", Consulta.class);	
			
			
			
			Consulta consulta = findAllQuery.getSingleResult();

			System.out.println("Consulta" + consulta);

			transaction.commit();

			return consulta;

		} catch (Exception e) {
			System.out.println("Erro recuperarConsulta");
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				//session.flush ();
			    //session.clear ();
				session.close();
			}
		}
	}


}
