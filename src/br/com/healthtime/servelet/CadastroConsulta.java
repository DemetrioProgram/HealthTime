package br.com.healthtime.servelet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtime.bo.ConsultaBO;
import br.com.healthtime.bo.UsuarioBO;
import br.com.healthtime.dao.UsuarioDAO;
import br.com.healthtime.entity.Consulta;
import br.com.healthtime.entity.Endereco;
import br.com.healthtime.entity.Usuario;

/**
 * Servlet implementation class CadastroConsulta
 */

public class CadastroConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	List<Usuario> medicos;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroConsulta() {
        super();
        listarMedicos();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 
		
		if (medicos != null)
		{
			request.setAttribute("medicos", medicos);
			RequestDispatcher rd = request.getRequestDispatcher("CadastroConsulta.jsp");
			rd.forward(request, response);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	
	private void validaDadosRecebidos(HttpServletRequest req) throws ServletException {

	

		String dtConsulta = req.getParameter("txtDtConsulta");
		String horario = req.getParameter("cbxHorario");
		String nmMedico = req.getParameter("cbxMedico");
		
		System.out.println("hora" + horario);
		
		String data = dtConsulta +" " + horario;
		
		System.out.println("data" + data);
		
		

			try {

				Consulta consulta = new Consulta();
				
				//teste
				Usuario objUsuario = UsuarioDAO.doLogin("08168815963");
			
				consulta.setData(LocalDate.parse(data, format));
				consulta.setCdFuncioanrio(objUsuario);
				consulta.setCdMedico(objUsuario);

				System.out.println("Consulta: "+consulta);
				
				
				ConsultaBO bo = new ConsultaBO();
				bo.salvaConsulta(consulta);;
				

			} catch (Exception e) {
				System.out.println("Erro: " + e);
			}

		}
	
private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
	
		try {
			System.out.println("teste");
			validaDadosRecebidos(req);
			RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			RequestDispatcher rd = req.getRequestDispatcher("ErroLogin.jsp");
			rd.forward(req, resp);
		}
	
	}




  public void listarMedicos() {
	  
	  medicos = UsuarioDAO.listarMedicos(2);
	 
  }

}
