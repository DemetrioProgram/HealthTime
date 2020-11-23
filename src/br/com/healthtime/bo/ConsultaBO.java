package br.com.healthtime.bo;

import br.com.healthtime.dao.ConsultaDAO;
import br.com.healthtime.entity.Consulta;

public class ConsultaBO {

	ConsultaDAO dao = new ConsultaDAO();
	
	public void salvaConsulta(Consulta consulta) {
		
		dao.salvarConsulta(consulta);
		
	}
	
	

}
