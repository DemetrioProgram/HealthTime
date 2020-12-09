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
	
	Usuario usuario;
	Usuario usuarioAlterado;
       
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		String cpf = request.getParameter("txtNuCpf");
		cpf = cpf.replace(".", "").replace("-", "");
		
		usuario = UsuarioDAO.doLogin(cpf);
		
		if (usuario != null) 
		{
			request.setAttribute("usuarioLogado", usuario);
			RequestDispatcher rd = request.getRequestDispatcher("ValidarUsuario.jsp");
			rd.forward(request, response);
			
		} 
		
		if (usuarioAlterado != null) {
			request.setAttribute("usuarioLogado", null);
			//RequestDispatcher rd = request.getRequestDispatcher("ValidarUsuario.jsp");
			//rd.forward(request, response);
			response.sendRedirect("ValidarUsuario");			
		}
	
			
	}	
			
		
			
	

	private void validaDadosRecebidos(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String tipoDeUsuario = request.getParameter("comboUsuario");		
		usuario.setCodigo(Integer.parseInt(tipoDeUsuario));
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			validaDadosRecebidos(request);
			usuarioAlterado = UsuarioBO.validaUsuario(usuario);
			RequestDispatcher rd = request.getRequestDispatcher("ValidarUsuario.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
