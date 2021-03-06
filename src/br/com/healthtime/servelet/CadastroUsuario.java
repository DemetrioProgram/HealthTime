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

import br.com.healthtime.bo.UsuarioBO;
import br.com.healthtime.dao.UnidadeDAO;
import br.com.healthtime.entity.Endereco;
import br.com.healthtime.entity.UnidadeSus;
import br.com.healthtime.entity.Usuario;



/**
 * Servlet implementation class CadastroUsuario
 */
public class CadastroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	List<UnidadeSus> unidades;
	String msg = new String();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		listarUnidades();
		request.setAttribute("unidades", unidades);
		RequestDispatcher rd = request.getRequestDispatcher("CadastroUsuario.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		listarUnidades();
		processRequest(request, response);
	}
	
	private void validaDadosRecebidos(HttpServletRequest req) throws ServletException {

		// Cadastrar Usuario

		String nmUsuario = req.getParameter("txtNome");
		String nuCpf = req.getParameter("txtNuCpf");
		nuCpf = nuCpf.replace(".", "").replace("-", "");
		String dtNascimento = req.getParameter("txtDtNascimento");	
		String email = req.getParameter("txtEmail");
		String flGestante = req.getParameter("flGestante");
		String flIdoso = req.getParameter("flIdoso");
		String flMenorIdade = req.getParameter("flMenorIdade");
		String flPne = req.getParameter("flPne");
		String nmMae = req.getParameter("txtNmMae");
		String nuContato = req.getParameter("txtNuContato");
		String nuContato2 = req.getParameter("txtNuContato2");
		String nuSus = req.getParameter("txtNuSus");
		
		String NmUnidade = req.getParameter("cbxUnidade");
		int cdUnidade = Integer.parseInt(NmUnidade);
		
		UnidadeSus unidade = UnidadeDAO.recuperaUnidade(cdUnidade);
		
		String nmRua = req.getParameter("txtNmRua");
		String numero = req.getParameter("txtNumero");
		String nmBairro = req.getParameter("txtBairro");
		String nmCidade = req.getParameter("txtCidade");
		String UF = req.getParameter("cbxUf");
		String nuCep = req.getParameter("txtCep");
		
			try {
				Usuario usuario = new Usuario();
				usuario.setCodigo(1);
				usuario.setNome(nmUsuario);
				usuario.setCpf(nuCpf);
				usuario.setDtnascimento(LocalDate.parse(dtNascimento, format));
				
				usuario.setNuContatoPrincipal(nuContato);
				usuario.setNuContatoSecundario(nuContato2);
				usuario.setNomeMae(nmMae);
				usuario.setEmail(email);
				usuario.setFlGestante(Boolean.parseBoolean(flGestante));
				usuario.setFlIdoso(Boolean.parseBoolean(flIdoso));
				usuario.setFlMenorIdade(Boolean.parseBoolean(flMenorIdade));
				usuario.setFlPne(Boolean.parseBoolean(flPne));
				usuario.setSus(nuSus);
				usuario.setCdUnidade(unidade);
				
				Endereco endereco = new Endereco();
				endereco.setBairro(nmBairro);
				endereco.setCep(nuCep);
				endereco.setCidade(nmCidade);
				endereco.setNumero(Integer.parseInt(numero));
				endereco.setRua(nmRua);
				endereco.setUf(UF);
				usuario.setEndereco(endereco);
				
				UsuarioBO bo = new UsuarioBO();
				msg = bo.salvaUsuario(usuario);;
				

			} catch (Exception e) {
				System.out.println("Erro: " + e);
			}

		}
	
private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			validaDadosRecebidos(req);
			
			req.setAttribute("msg", msg);
			
			if (msg.equals("Sucesso")) {
				RequestDispatcher rd = req.getRequestDispatcher("Login");				
				rd.forward(req, resp);
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("CadastroUsuario.jsp");				
				rd.forward(req, resp);
			}

		} catch (Exception e) {
			RequestDispatcher rd = req.getRequestDispatcher("CadastroUsuario.jsp");
			rd.forward(req, resp);
		}
	
	}

	private void listarUnidades() {
		
		unidades = UnidadeDAO.listarUnidades();
	}
}
