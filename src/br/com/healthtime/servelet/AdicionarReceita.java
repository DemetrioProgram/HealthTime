package br.com.healthtime.servelet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtime.bo.ConsultaBO;
import br.com.healthtime.entity.Consulta;
import br.com.healthtime.entity.Usuario;

/**
 * Servlet implementation class AdicionarReceita
 */
@WebServlet("/AdicionarReceita")
public class AdicionarReceita extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Usuario usuarioLogado;
	private Consulta consulta;
	private String msg;
	DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionarReceita() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String data = request.getParameter("txtDtConsulta");
		String horario = request.getParameter("cbxHorario");
		LocalDate dtConsulta = LocalDate.parse(data, format);
		
		msg = ConsultaBO.validarData(dtConsulta);
		
		if (!msg.isEmpty()) 
		{
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("AdicionarReceita.jsp");
			rd.forward(request, response);
		}
		
		int cdUsuario = usuarioLogado.getCdUsuario();
		
		consulta = ConsultaBO.recuperarConsulta(dtConsulta, cdUsuario, horario);
		
		
		if (consulta != null) 
		{
			request.setAttribute("consulta", consulta);
			RequestDispatcher rd = request.getRequestDispatcher("AdicionarReceita.jsp");
			rd.forward(request, response);
			
		} 
		else 
		{
			msg = "Não foi encontrado nenhuma consulta agendada para a data selecionada";
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("AdicionarReceita.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if (usuarioLogado == null) 
		{
			usuarioLogado = (Usuario) request.getSession().getAttribute("usuario");	
			System.out.println("usuarioLogado: "+usuarioLogado.getCdUsuario());
		}
		
//		if (consulta != null) 
//		{
//			consulta.setCdPaciente(null);
//			consulta.setRetorno(false);
//			consulta.setDeprediagnostico("");
//			consulta.setFlvacina(false);
//			
//			consulta = ConsultaBO.agendarConsulta(consulta);
//			
//			msg = "Sucesso";
//			request.setAttribute("msg", msg);
//			
//			RequestDispatcher rd = request.getRequestDispatcher("AdicionarReceita.jsp");
//			rd.forward(request, response);
//			
//		}
		
		if (consulta == null) {
			doGet(request, response);			
		}
		
	}

}
