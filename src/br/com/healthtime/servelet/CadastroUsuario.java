package br.com.healthtime.servelet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtime.bo.UsuarioBO;
import br.com.healthtime.entity.Endereco;
import br.com.healthtime.entity.Usuario;



/**
 * Servlet implementation class CadastroUsuario
 */
public class CadastroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	
	private void validaDadosRecebidos(HttpServletRequest req) throws ServletException {

		// Cadastrar Usuario

		String nmUsuario = req.getParameter("txtNome");
		String nuCpf = req.getParameter("txtNuCpf");
		
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
				
				System.out.println("data: "+usuario.getDtnascimento());
				
				usuario.setNuContatoPrincipal(nuContato);
				usuario.setNuContatoSecundario(nuContato2);
				usuario.setNomeMae(nmMae);
				usuario.setEmail(email);
				usuario.setFlGestante(Boolean.parseBoolean(flGestante));
				usuario.setFlIdoso(Boolean.parseBoolean(flIdoso));
				usuario.setFlMenorIdade(Boolean.parseBoolean(flMenorIdade));
				usuario.setFlPne(Boolean.parseBoolean(flPne));
				usuario.setSus(nuSus);
				
				Endereco endereco = new Endereco();
				endereco.setBairro(nmBairro);
				endereco.setCep(nuCep);
				endereco.setCidade(nmCidade);
				endereco.setNumero(Integer.parseInt(numero));
				endereco.setRua(nmRua);
				endereco.setUf(UF);
				usuario.setEndereco(endereco);
				
				System.out.println("Usuario: "+usuario);
				
				
				UsuarioBO bo = new UsuarioBO();
				bo.salvaUsuario(usuario);;
				

			} catch (Exception e) {
				System.out.println("Erro: " + e);
			}

		}
	
private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			validaDadosRecebidos(req);
			RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			RequestDispatcher rd = req.getRequestDispatcher("ErroLogin.jsp");
			rd.forward(req, resp);
		}
	
	}
}
