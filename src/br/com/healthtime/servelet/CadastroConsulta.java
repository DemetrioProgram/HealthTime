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
	private Usuario usuarioLogado = new Usuario();
	
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroConsulta() {
        super();
        System.out.println("Inicial");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	System.out.println("Inicial get");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inicial post");
		processRequest(request, response);
	}
	
	private void validaDadosRecebidos(HttpServletRequest req) throws ServletException {

		// Cadastrar Usuario

		String dtConsulta = req.getParameter("txtDtConsulta");
		String horario = req.getParameter("cbxHorario");
		String nmMedico = req.getParameter("cbxMedico");
		
			try {

				Consulta consulta = new Consulta();
				
				//teste
				Usuario objUsuario = UsuarioDAO.doLogin("08168815963");
			
				consulta.setData(LocalDate.parse(dtConsulta, format));
				consulta.setCdFuncioanrio(usuarioLogado);
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
			usuarioLogado = (Usuario) req.getSession().getAttribute("usuario");
			validaDadosRecebidos(req);
			RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			RequestDispatcher rd = req.getRequestDispatcher("ErroLogin.jsp");
			rd.forward(req, resp);
		}
	
	}
}
