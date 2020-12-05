package br.com.healthtime.bo;

import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.healthtime.dao.ConsultaDAO;
import br.com.healthtime.entity.Consulta;

public class ConsultaBO {

	ConsultaDAO dao = new ConsultaDAO();
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	String msg = "";
	
	public String salvaConsulta(Consulta consulta) throws Exception {
		
		msg = validarConsulta(consulta);
		
		if (msg.isEmpty()) 
		{
			dao.salvarConsulta(consulta);
			msg = "Sucesso";
		}

		return msg;
	}

	private String validarConsulta(Consulta consulta) throws Exception {
		// TODO Auto-generated method stub
		
		int cdMedico = consulta.getCdMedico().getCdUsuario();
		int cdUnidade = consulta.getCdUnidade().getCdUnidade();
		
		List<Consulta> consultas = ConsultaDAO.listarConsultas(cdMedico, cdUnidade);
		
		DayOfWeek dia = consulta.getData().getDayOfWeek();
		
		if (dia == DayOfWeek.SUNDAY || dia == DayOfWeek.SATURDAY) 
		{
			return "Dia Inválido, selecione um dia util";
			
		}
		
		for (Consulta objConsulta : consultas) 
		{
			
			if (objConsulta.getData().compareTo(consulta.getData()) == 0)  
			{
				if (objConsulta.getHorario().equals(consulta.getHorario())) 
				{
					return "Consulta já cadastrada, selecione outro Médico ou outro Horário";
				}
			}
			
			
		}
		
		return msg;
	}
	
	

}
