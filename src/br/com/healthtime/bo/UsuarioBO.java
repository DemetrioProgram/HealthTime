package br.com.healthtime.bo;

import java.time.LocalDate;

import br.com.healthtime.dao.UsuarioDAO;
import br.com.healthtime.entity.Usuario;

public class UsuarioBO {
	
	UsuarioDAO dao = new UsuarioDAO();

	public void salvaUsuario(Usuario usuario) throws Exception {
		
		
		Usuario objUsuario = dao.doLogin(usuario.getCpf());
		
		if (!this.validaCPF(usuario.getCpf()).isEmpty())
		{
			throw new Exception("CPF Inválido");	
		}
		
		if (objUsuario != null)
		{
			throw new Exception("CPF já cadastrado");	
		}
		
		//RN12
		LocalDate data = usuario.getDtnascimento();
		LocalDate dataAtual = LocalDate.now();
		
		
		if (data.equals(dataAtual) )
		{
			throw new Exception("A data informada está inválida");			
		}
		
		if (data.isAfter(dataAtual)) 
		{
			throw new Exception("A data informada está inválida");			
		}
		
		if (dataAtual.minusYears(100).isAfter(data)) 
		{
			throw new Exception("A data informada está inválida");
		}
		
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
	
	public static String validaCPF(String CPF) {
		String mensagem = "";
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return mensagem += " O CPF informado não é válido! \n";
          
        char dig10, dig11;
        int sm, i, r, num, peso;
          
        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {              
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0         
        // (48 eh a posicao de '0' na tabela ASCII)         
            num = (int)(CPF.charAt(i) - 48); 
            sm = sm + (num * peso);
            peso = peso - 1;
            }
          
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico
          
        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }
          
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);
          
        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return mensagem = "";
            else return mensagem += " O CPF informado não é válido! \n";
                } catch (Exception erro) {
                 return mensagem += " O CPF informado não é válido! \n";
            }
        }

	public static Usuario recuperarUsuario(int cdMedico) {
		
		Usuario objMedico = UsuarioDAO.recuperarUsuario(cdMedico);
		
		return objMedico;
	}


}
