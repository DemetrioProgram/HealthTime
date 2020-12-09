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
import br.com.healthtime.dao.UnidadeDAO;
import br.com.healthtime.dao.UsuarioDAO;
import br.com.healthtime.entity.Consulta;
import br.com.healthtime.entity.UnidadeSus;
import br.com.healthtime.entity.Usuario;

/**
 * Servlet implementation class CadastroConsulta
 */

public class CadastroConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Usuario usuarioLogado;
	
	DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	List<Usuario> medicos;
	String msg;
       
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		
		medicos = UsuarioDAO.listarMedicos(2);
		
		if (medicos != null || medicos.size() > 0)
		{
			
			usuarioLogado = (Usuario) request.getSession().getAttribute("usuario");
			request.setAttribute("medicos", medicos);
			
			
			try {
				validaDadosRecebidos(request);
				
				request.setAttribute("msg", msg);
				RequestDispatcher rd = request.getRequestDispatcher("CadastroConsulta.jsp");
				rd.forward(request, response);

			} catch (Exception e) {
				System.out.println("Erro" + e);
				RequestDispatcher rd = request.getRequestDispatcher("CadastroConsulta.jsp");
				rd.forward(request, response);
			}
			
			
		}	
		
	}
	
	private void validaDadosRecebidos(HttpServletRequest req) throws ServletException {

	

		String dtConsulta = req.getParameter("txtDtConsulta");
		String horario = req.getParameter("cbxHorario");
		String Medico = req.getParameter("cbxMedico");
		
		
		
			try {
				
				
				int cdMedico = Integer.parseInt(Medico);	
				Usuario objMedico = UsuarioBO.recuperarUsuario(cdMedico);	
				
				String f = usuarioLogado.getCdUsuario().toString();		
				Usuario objFuncionario = UsuarioBO.recuperarUsuario(Integer.parseInt(f));	
				
				int u = usuarioLogado.getCdUnidade().getCdUnidade();
				UnidadeSus unidade = UnidadeDAO.recuperaUnidade(u);
				
				Consulta consulta = new Consulta();
				
				consulta.setData(LocalDate.parse(dtConsulta, format));				
				consulta.setHorario(horario);
				consulta.setCdFuncioanrio(objFuncionario);
				consulta.setCdMedico(objMedico);
				consulta.setCdUnidade(unidade);				
				
				ConsultaBO bo = new ConsultaBO();
				msg = bo.salvaConsulta(consulta);;				

			} catch (Exception e) {
				System.out.println("Erro: " + e);
			}

		}
	


  public void listarMedicos() {
	  
	  medicos = UsuarioDAO.listarMedicos(2);
	 
  }

}
