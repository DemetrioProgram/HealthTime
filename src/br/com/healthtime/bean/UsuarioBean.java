package br.com.healthtime.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.healthtime.dao.UsuarioDAO;
import br.com.healthtime.entity.Usuario;

@ManagedBean(name = "Login")
@ViewScoped
public class UsuarioBean {
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();
	
	public String salva() {

	    usuarioDAO.salvaUsuario(usuario);
	    if (usuario == null) {
	      usuario = new Usuario();
	      System.out.println("Usuario não encontrado");
	      return "/login";
	    } /*else { Fazer pagina de erro
	          return "/login";
	    }*/return null;


	  }

	  public Usuario getUsuario() {
	    return usuario;
	  }

	  public void setUsuario(Usuario usuario) {
	    this.usuario = usuario;
	  }

}
