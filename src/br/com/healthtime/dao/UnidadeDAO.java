package br.com.healthtime.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.healthtime.entity.UnidadeSus;
import br.com.healthtime.entity.Usuario;
import br.com.healthtime.util.HibernateUtil;

public class UnidadeDAO {

	public static List<UnidadeSus> listarUnidades() {
	
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			TypedQuery<UnidadeSus> findAllQuery = session.createQuery("from UnidadeSus", UnidadeSus.class);	
			
			
			
			List<UnidadeSus> unidades = findAllQuery.getResultList();

			System.out.println("Usuario" + unidades.size());

			transaction.commit();

			return unidades;

		} catch (Exception e) {
			System.out.println("Erro listar Unidades");
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		
	}

	public static UnidadeSus recuperaUnidade(int cdUnidade) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();	
			
			TypedQuery<UnidadeSus> findAllQuery = session.createQuery("from UnidadeSus where cdUnidade="+ cdUnidade, UnidadeSus.class);	
			
			
			
			UnidadeSus unidade = findAllQuery.getSingleResult();

			System.out.println("Usuario" + unidade);

			transaction.commit();

			return unidade;

		} catch (Exception e) {
			System.out.println("Erro doListarMedico");
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				//session.flush ();
			    session.clear ();
				session.close();
				
			}
		}
	}

	public static UnidadeSus obterUnidadeGestor(Integer cdGestor) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();	
			
			TypedQuery<UnidadeSus> findAllQuery = session.createQuery("from UnidadeSus where cdGestor="+ cdGestor 
					+ " group by cdGestor", UnidadeSus.class);	
			
			
			
			UnidadeSus unidade = findAllQuery.getSingleResult();

			System.out.println("Unidade" + unidade);

			transaction.commit();

			return unidade;

		} catch (Exception e) {
			System.out.println("Erro doObterGestor");
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				//session.flush ();
			    session.clear ();
				session.close();
				
			}
		}
	}

}
