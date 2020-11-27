package br.com.healthtime.bo;

import java.time.LocalDate;

import br.com.healthtime.dao.UsuarioDAO;
import br.com.healthtime.entity.Usuario;

public class UsuarioBO {
	
	UsuarioDAO dao = new UsuarioDAO();

	public void salvaUsuario(Usuario usuario) throws Exception {
		
		
		Usuario objUsuario = dao.doLogin(usuario.getCpf());
		
		if (objUsuario != null)
		{
			throw new Exception("CPF já cadastrado");	
		}
		
		//RN12
		LocalDate data = usuario.getDtnascimento();
		LocalDate dataAtual = LocalDate.now();
		
		if (data.plusYears(18).isBefore(dataAtual) && usuario.isFlMenorIdade()) 
		{
			throw new Exception("A data informada está inválida para usuário menor de idade");			
		}
		
		if (data.plusYears(18).isAfter(dataAtual) && !usuario.isFlMenorIdade()) 
		{
			throw new Exception("É obrigatorio selecionar a opção Menor de Idade");
		}
		
		if (usuario.isFlMenorIdade() == true && usuario.getNomeMae().isEmpty())
		{
			throw new Exception("É obrigatorio informar o nome do Responsável quando usuário é menor de idade");
		}
		
		if (usuario.isFlIdoso() && usuario.isFlMenorIdade()) 
		{
			throw new Exception("O usuário não pode ser Idoso e Menor de Idade ao mesmo tempo");
		}
		
		if (usuario.isFlIdoso() && usuario.isFlGestante()) 
		{
			throw new Exception("O usuário não pode ser Idoso e Gestante ao mesmo tempo");
		}
		
		dao.salvaUsuario(usuario);
		
	}

	public static Usuario validaUsuario(Usuario usuario) throws Exception {
		
		Usuario objUsuario = UsuarioDAO.doLogin(usuario.getCpf());
		
		if (objUsuario.getCodigo() == usuario.getCodigo()) 
		{
			throw new Exception("Não é possível alterar o tipo de usuario quando o tipo selecionado já é o mesmo do cadastro");
		}
		
		return UsuarioDAO.validaUsuario(usuario);
		
		
	}
	
	

}
