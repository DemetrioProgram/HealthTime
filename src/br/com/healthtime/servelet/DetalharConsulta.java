package br.com.healthtime.servelet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtime.bo.ConsultaBO;
import br.com.healthtime.dao.UsuarioDAO;
import br.com.healthtime.entity.Consulta;
import br.com.healthtime.entity.Usuario;

/**
 * Servlet implementation class DetalharConsulta
 */

public class DetalharConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Usuario usuarioLogado;
	Consulta consulta;
	DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	String msg;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetalharConsulta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String data = request.getParameter("txtDtConsulta");
		LocalDate dtConsulta = LocalDate.parse(data, format);
		
		msg = ConsultaBO.validarDataDetalhe(dtConsulta);
		
		if (!msg.isEmpty()) 
		{
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("DetalharConsulta.jsp");
			rd.forward(request, response);
		}
		
		int cdUsuario = usuarioLogado.getCdUsuario();
		
		consulta = ConsultaBO.obterConsulta(dtConsulta, cdUsuario);
		
		if (consulta != null) 
		{
			Usuario medico = UsuarioDAO.recuperarUsuario(consulta.getCdMedico().getCdUsuario());
			
			request.setAttribute("medico", medico);
			request.setAttribute("consulta", consulta);
			RequestDispatcher rd = request.getRequestDispatcher("DetalharConsulta.jsp");
			rd.forward(request, response);
			
		} 
		else 
		{
			msg = "Não foi encontrado nenhuma consulta para a data selecionada";
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("DetalharConsulta.jsp");
			rd.forward(request, response);
		}
		
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
		}
		
		if (consulta == null) 
		{
			doGet(request, response);
		}
		
		
		doGet(request, response);
	}

}
