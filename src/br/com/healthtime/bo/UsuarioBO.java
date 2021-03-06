package br.com.healthtime.bo;

import java.time.LocalDate;

import br.com.healthtime.dao.UsuarioDAO;
import br.com.healthtime.entity.Usuario;

public class UsuarioBO {
	
	UsuarioDAO dao = new UsuarioDAO();

	public String salvaUsuario(Usuario usuario)  {
		
		
		Usuario objUsuario = dao.doLogin(usuario.getCpf());
		
		if (!this.validaCPF(usuario.getCpf()).isEmpty())
		{
			return "CPF Inv�lido";	
		}
		
		if (objUsuario != null)
		{
			return "CPF j� cadastrado";	
		}
		
		//RN12
		LocalDate data = usuario.getDtnascimento();
		LocalDate dataAtual = LocalDate.now();
		
		
		if (data.equals(dataAtual) )
		{
			return "A data informada est� inv�lida";			
		}
		
		if (data.isAfter(dataAtual)) 
		{
			return "A data informada est� inv�lida";			
		}
		
		if (dataAtual.minusYears(100).isAfter(data)) 
		{
			return "A data informada est� inv�lida";
		}
		
		if (data.plusYears(18).isBefore(dataAtual) && usuario.isFlMenorIdade()) 
		{
			return "A data informada est� inv�lida para usu�rio menor de idade";			
		}
		
		if (data.plusYears(18).isAfter(dataAtual) && !usuario.isFlMenorIdade()) 
		{
			return "� obrigatorio selecionar a op��o Menor de Idade";
		}
		
		if (usuario.isFlMenorIdade() == true && usuario.getNomeMae().isEmpty())
		{
			return "� obrigatorio informar o nome do Respons�vel quando usu�rio � menor de idade";
		}
		
		if (usuario.isFlIdoso() && usuario.isFlMenorIdade()) 
		{
			return "O usu�rio n�o pode ser Idoso e Menor de Idade ao mesmo tempo";
		}
		
		if (usuario.isFlIdoso() && usuario.isFlGestante()) 
		{
			return "O usu�rio n�o pode ser Idoso e Gestante ao mesmo tempo";
		}
		
		dao.salvaUsuario(usuario);
		
		return "Sucesso";
		
		
	}

	public static Usuario validaUsuario(Usuario usuario) throws Exception {
		
		Usuario objUsuario = UsuarioDAO.doLogin(usuario.getCpf());
		
		if (objUsuario.getCodigo() == usuario.getCodigo()) 
		{
			throw new Exception("N�o � poss�vel alterar o tipo de usuario quando o tipo selecionado j� � o mesmo do cadastro");
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
            return mensagem += " O CPF informado n�o � v�lido! \n";
          
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
            else return mensagem += " O CPF informado n�o � v�lido! \n";
                } catch (Exception erro) {
                 return mensagem += " O CPF informado n�o � v�lido! \n";
            }
        }

	public static Usuario recuperarUsuario(int cdMedico) {
		
		Usuario objMedico = UsuarioDAO.recuperarUsuario(cdMedico);
		
		return objMedico;
	}


}
