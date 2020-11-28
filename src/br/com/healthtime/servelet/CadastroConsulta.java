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
import br.com.healthtime.dao.UsuarioDAO;
import br.com.healthtime.entity.Consulta;
import br.com.healthtime.entity.Usuario;

/**
 * Servlet implementation class CadastroConsulta
 */

public class CadastroConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Usuario usuarioLogado = new Usuario();
	
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	List<Usuario> medicos;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroConsulta() {
        super();
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
		
		medicos = UsuarioDAO.listarMedicos(2);
		
		if (medicos != null)
		{
			
			usuarioLogado = (Usuario) request.getSession().getAttribute("usuario");
			System.out.println("lista" + medicos.get(0).getNome());
			request.setAttribute("medicos", medicos);
			
			System.out.println("user " + usuarioLogado.getNome());
			validaDadosRecebidos(request);
			RequestDispatcher rd = request.getRequestDispatcher("CadastroConsulta.jsp");
			rd.forward(request, response);
		}	
		
	}
	
	private void validaDadosRecebidos(HttpServletRequest req) throws ServletException {

	

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
	


  public void listarMedicos() {
	  
	  medicos = UsuarioDAO.listarMedicos(2);
	 
  }

}
