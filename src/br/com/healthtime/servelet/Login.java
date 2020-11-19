package br.com.healthtime.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtime.dao.UsuarioDAO;
import br.com.healthtime.entity.Usuario;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		
		Usuario usuario = new Usuario();
		usuario = UsuarioDAO.doLogin(cpf);
		
		if (usuario != null) {
			RequestDispatcher rd = request.getRequestDispatcher("Principal.jsp");
			rd.forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function() {");
			out.println("swal ('Usu�rio n�o encontrado', '', 'error' );");
			out.println("});");
			out.println("</script>");

			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		}
				
	}

}
