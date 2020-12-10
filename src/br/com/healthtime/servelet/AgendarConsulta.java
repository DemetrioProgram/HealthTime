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
import br.com.healthtime.dao.ConsultaDAO;
import br.com.healthtime.dao.UsuarioDAO;
import br.com.healthtime.entity.Consulta;
import br.com.healthtime.entity.Usuario;

/**
 * Servlet implementation class AgendarConsulta
 */

public class AgendarConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Usuario usuarioLogado;
	Consulta consulta = new Consulta();
	Consulta consultaAgendada = new Consulta();
	DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	List<Consulta> lstConsultas;
    String msg;
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
		
		msg = ConsultaBO.validarData(dtConsulta);
		
		if (!msg.isEmpty()) 
		{
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("AgendarConsulta.jsp");
			rd.forward(request, response);
		}
		
		Consulta objConsulta = ConsultaDAO.obterConsulta(dtConsulta, usuarioLogado.getCdUsuario());
		
		if (objConsulta != null)
		{
			msg = "Já há uma consulta agendada para a data selecionada";
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("AgendarConsulta.jsp");
			rd.forward(request, response);
		}
		
		lstConsultas = ConsultaBO.listarConsultas(dtConsulta);
		

		
		if (lstConsultas != null) 
		{
			consulta.setData(dtConsulta);			
			request.setAttribute("consulta", consulta);
			request.setAttribute("lstConsultas", lstConsultas);	
			RequestDispatcher rd = request.getRequestDispatcher("AgendarConsulta.jsp");
			rd.forward(request, response);
			
		} 
		else 
		{
			msg = "Não há consultas disponíveis para a data selecionada";
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("AgendarConsulta.jsp");
			rd.forward(request, response);
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	private void validaDadosRecebidos(HttpServletRequest request) 
	{
		// TODO Auto-generated method stub
		String cdConsulta = request.getParameter("cbxConsulta");	
		int idConsulta = Integer.parseInt(cdConsulta);
		
		String vacina = request.getParameter("flVacina");
		String retorno = request.getParameter("flRetorno");
		String sintomas = request.getParameter("txtPrediagnostico");
		
		System.out.println("cd consulta"  + cdConsulta);
		
		consultaAgendada = ConsultaDAO.obterConsulta(idConsulta);
		
		consultaAgendada.setFlvacina(Boolean.parseBoolean(vacina));
		consultaAgendada.setRetorno(Boolean.parseBoolean(retorno));
		consultaAgendada.setDeprediagnostico(sintomas);
		consultaAgendada.setCdPaciente(usuarioLogado);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			usuarioLogado = (Usuario) request.getSession().getAttribute("usuario");
			validaDadosRecebidos(request);
			consultaAgendada = ConsultaBO.agendarConsulta(consultaAgendada);
			
			if (consultaAgendada != null) 
			{
				msg = "Sucesso";
				request.setAttribute("msg", msg);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("AgendarConsulta.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			doGet(request, response);
		
		
		
	}

}
