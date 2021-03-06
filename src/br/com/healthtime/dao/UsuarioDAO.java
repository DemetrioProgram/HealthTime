package br.com.healthtime.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.healthtime.entity.Endereco;
import br.com.healthtime.entity.Gestor;
import br.com.healthtime.entity.Usuario;
import br.com.healthtime.util.HibernateUtil;

public class UsuarioDAO {

	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		usuario.setCodigo(1);
		usuario.setNome("Mocorongo");
		usuario.setCpf("112321454357");
		usuario.setDtnascimento(LocalDate.now());
		usuario.setNuContatoPrincipal("98377348");
		usuario.setNomeMae("nomeMae");
		usuario.setEmail("email@email.com");
		usuario.setFlGestante(false);
		usuario.setFlIdoso(false);
		usuario.setFlMenorIdade(false);
		usuario.setFlPne(false);
		usuario.setSus("123");
		Endereco endereco = new Endereco();
		endereco.setBairro("bairro");
		endereco.setCep("23435754");
		endereco.setCidade("cidade");
		endereco.setNumero(12);
		endereco.setRua("rua");
		endereco.setUf("uf");
		usuario.setEndereco(endereco);
		// salvaUsuario(usuario);
		listarTodos();
	}

	public static void salvaUsuario(Usuario usuario) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			System.out.println("usuario " + usuario);
			session.save(usuario);

			transaction.commit();

		} catch (Exception e) {
			System.out.println("Erro salvaUsuario");
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public static List<Usuario> listarTodos() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			Criteria query = session.createCriteria(Usuario.class);
			List<Usuario> usuarios = query.list();

			System.out.println("Usuarios" + usuarios);

			transaction.commit();

			return usuarios;

		} catch (Exception e) {
			System.out.println("Erro listarTodos");
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				session.flush ();
			    session.clear ();
				session.close();
			}
		}
	}

	public static Usuario doLogin(String cpf) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			Criteria query = session.createCriteria(Usuario.class);
			Usuario usuario = (Usuario) query.add(Restrictions.eq("cpf", cpf)).uniqueResult();

			System.out.println("Usuario" + usuario);

			transaction.commit();

			return usuario;

		} catch (Exception e) {
			System.out.println("Erro doLogin Usuario");
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	

	public static Usuario validaUsuario(Usuario usuario) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();

			session.update(usuario);

			transaction.commit();

			return usuario;

		} catch (Exception e) {
			System.out.println("Erro validaUsuario");
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public static List<Usuario> listarMedicos(int codigo) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			TypedQuery<Usuario> findAllQuery = session.createQuery("from Usuario where codigo="+codigo, Usuario.class);	
						
			
			List<Usuario> medicos = findAllQuery.getResultList();

			System.out.println("Usuario" + medicos.size());

			transaction.commit();
			
			if (medicos.size() > 0) {
				return medicos;
			}
			else {
				return null;
			}

		} catch (Exception e) {
			System.out.println("Erro doListarMedico");
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public static Usuario recuperarUsuario(int cdMedico) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();	
			
			TypedQuery<Usuario> findAllQuery = session.createQuery("from Usuario where cdUsuario="+cdMedico, Usuario.class);	
			
			
			
			Usuario medico = findAllQuery.getSingleResult();

			System.out.println("Medico" + medico);

			transaction.commit();

			return medico;

		} catch (Exception e) {
			System.out.println("Erro doListarMedico");
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
