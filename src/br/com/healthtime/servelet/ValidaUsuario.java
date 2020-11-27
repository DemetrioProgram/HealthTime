package br.com.healthtime.servelet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtime.bo.UsuarioBO;
import br.com.healthtime.dao.UsuarioDAO;
import br.com.healthtime.entity.Usuario;

/**
 * Servlet implementation class ValidaUsuario
 */
public class ValidaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String cpf = request.getParameter("txtNuCpf");
		System.out.println("CPF: "+cpf);
		
		Usuario usuario = new Usuario();
		usuario = UsuarioDAO.doLogin(cpf);
		System.out.println(usuario);
		
		if (usuario != null) {
			request.setAttribute("usuario", usuario);
			RequestDispatcher rd = request.getRequestDispatcher("Login");
			rd.forward(request, response);
		} else {
			
		}

		String tipoDeUsuario = request.getParameter("comboUsuario");
		usuario.setCodigo(Integer.parseInt(tipoDeUsuario));
		System.out.println("tipoDeUsuario: "+tipoDeUsuario);
		
		Usuario usuarioAlterado = null;
		try {
			usuarioAlterado = UsuarioBO.validaUsuario(usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (usuarioAlterado != null) {
			request.setAttribute("usuario", null);
			RequestDispatcher rd = request.getRequestDispatcher("ValidarUsuario.jsp");
			rd.forward(request, response);
		} else {
			
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
