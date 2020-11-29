package br.com.healthtime.servelet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtime.dao.GestorDAO;
import br.com.healthtime.dao.UnidadeDAO;
import br.com.healthtime.dao.UsuarioDAO;
import br.com.healthtime.entity.Gestor;
import br.com.healthtime.entity.UnidadeSus;
import br.com.healthtime.entity.Usuario;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<UnidadeSus> unidades;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		popularComboUnidade();
		request.setAttribute("unidades", unidades);
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);
	}

	private void popularComboUnidade() {
		unidades = UnidadeDAO.listarUnidades();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		validaLogin(request, response);
	}

	private void validaLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String cpf = request.getParameter("txtCpf");
		cpf = cpf.replace(".", "").replace("-", "");
		
		
		Gestor gestor = new Gestor();
		gestor = GestorDAO.doLogin(cpf);
		
		Usuario usuario = new Usuario();
		usuario = UsuarioDAO.doLogin(cpf);
		
		
		if (gestor != null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("Principal.jsp");
			request.getSession().setAttribute("gestor", gestor);
			rd.forward(request, response); 
		}
		
		if (usuario != null)
		{
				RequestDispatcher rd = request.getRequestDispatcher("CadastroConsulta");
				request.getSession().setAttribute("usuario", usuario);
				rd.forward(request, response);
		}

		 if (usuario == null && gestor == null) 
		 {
			 request.setAttribute("erro", new Exception("Usu�rio n�o encontrado."));
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
		 }
		 
			
		
				
	}

}
