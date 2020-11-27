<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Cadastrar Consulta</title>
</head>


<body>


	<form action="CadastroConsulta" method="post">

		<table id="tblPrincipal" border="1">

			<tr>
				<td>

					<h3 id="titulo" align="center">Informe os dados da Consulta</h3>
					<table id="tblCadastro" align="center">

						<tr>
							<td align="right"><label class="fonte">Data da Consulta:</label></td>
							<td align="left"><input type="date" size="10" name="txtDtConsulta"
								required /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Horário:</label></td>
							<td><select id="cbxHorario" name="cbxHorario" required>
								<option value="">Nenhuma</option>
								<option value="08:00">08:00</option>
 								 <option value="08:30">08:30</option>
  								<option value="09:00">09:00</option>
								  <option value="09:30">09:30</option>
								  <option value="10:00">10:00</option>
								  <option value="10:30">10:30</option>							 
  								<option value="11:00">11:00</option>
								  <option value="11:30">11:30</option>
								  <option value="13:00">13:00</option>
								  <option value="13:30">13:30</option>
  								<option value="14:00">14:00</option>
								  <option value="14:30">14:30</option>
								  <option value="15:00">15:00</option>
								  <option value="15:30">15:30</option>							 
  								<option value="16:00">16:00</option>
								  <option value="16:30">16:30</option>								  
								</select></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Médico:</label></td>
							<td><select id="cbxMedico" name="cbxMedico" required>
							<option value="">Selecione</option>
							<c:forEach var="medicos" items="${medicos}">
							<option value="${medicos.cdUsuario}">
							${medicos.nome}
							</option>
							</c:forEach>
							</select></td>
						</tr>

						
					</table>



					<table id="tblBotao">
						<tr>
							<td width="965px" align="right"><input type="submit"
								value="Vamos Lá" /></td>
						</tr>
					</table>

				</td>
			</tr>
		</table>


	</form>

</body>
</html>