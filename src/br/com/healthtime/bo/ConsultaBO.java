package br.com.healthtime.bo;

import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.healthtime.dao.ConsultaDAO;
import br.com.healthtime.entity.Consulta;

public class ConsultaBO {

	ConsultaDAO dao = new ConsultaDAO();
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public void salvaConsulta(Consulta consulta) throws Exception {
		
		validarConsulta(consulta);
		
		System.out.println("vai salvar");
		dao.salvarConsulta(consulta);
		
	}

	private void validarConsulta(Consulta consulta) throws Exception {
		// TODO Auto-generated method stub
		
		int cdMedico = consulta.getCdMedico().getCdUsuario();
		int cdUnidade = consulta.getCdUnidade().getCdUnidade();
		
		List<Consulta> consultas = ConsultaDAO.listarConsultas(cdMedico, cdUnidade);
		
		System.out.println("lista de consultas" + consultas);
			
		
		for (Consulta objConsulta : consultas) 
		{
			System.out.println("datas" + objConsulta.getData().format(format));
			if (objConsulta.getData().format(format).equals(consulta.getData().format(format))) 
			{
				if (objConsulta.getHorario().equals(consulta.getHorario())) 
				{
					throw new Exception("Consulta já cadastrada, selecione outro Médico ou outro Horário");
				}
			}
			
			
		}
		
	}
	
	

}
