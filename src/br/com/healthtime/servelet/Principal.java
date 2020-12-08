package br.com.healthtime.servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtime.entity.Usuario;

/**
 * Servlet implementation class Principal
 */

public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Usuario usuarioLogado;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Principal() {
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
		
		if (usuarioLogado == null) 
		{
			usuarioLogado = (Usuario) request.getSession().getAttribute("usuario");	
			RequestDispatcher rd = request.getRequestDispatcher("NavBar.jsp");
			rd.include(request, response);
		}
		
		/*doGet(request, response);*/
	}

}
