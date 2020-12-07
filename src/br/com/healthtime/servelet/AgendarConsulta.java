package br.com.healthtime.servelet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtime.bo.ConsultaBO;
import br.com.healthtime.bo.UsuarioBO;
import br.com.healthtime.dao.UsuarioDAO;
import br.com.healthtime.entity.Consulta;

/**
 * Servlet implementation class AgendarConsulta
 */

public class AgendarConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Consulta consulta = new Consulta();
	Consulta consultaAgendade;
	DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	List<Consulta> lstConsultas;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendarConsulta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String data = request.getParameter("txtDtConsulta");
		LocalDate dtConsulta = LocalDate.parse(data, format);
		
		lstConsultas = ConsultaBO.listarConsultas(dtConsulta);
		
		
		if (lstConsultas != null) 
		{
			consulta.setData(dtConsulta);			
			request.setAttribute("consulta", consulta);
			request.setAttribute("lstConsultas", lstConsultas);
			request.setAttribute("DtConsulta", data);
			RequestDispatcher rd = request.getRequestDispatcher("AgendarConsulta.jsp");
			rd.forward(request, response);
			
		} 
		
		//if (usuarioAlterado != null) {
			//request.setAttribute("usuario", null);
			//RequestDispatcher rd = request.getRequestDispatcher("ValidarUsuario.jsp");
			//rd.forward(request, response);
			//response.sendRedirect("ValidarUsuario");			
		//}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	private void validaDadosRecebidos(HttpServletRequest request) 
	{
		// TODO Auto-generated method stub
		String cdConsulta = request.getParameter("cbxConsuta");	
		System.out.println("recuperou " + cdConsulta);
		consulta.setCdConsulta(Integer.parseInt(cdConsulta));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			validaDadosRecebidos(request);
			//consutaAgendada = UsuarioBO.validaUsuario(usuario);
			RequestDispatcher rd = request.getRequestDispatcher("AgendarConsulta.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
