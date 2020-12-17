<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="br.com.healthtime.entity.Usuario"%>
    <%@page import="br.com.healthtime.entity.Consulta"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous" />
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>
<script
	src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Adicionar Receita</title>
</head>
<body id="adicionarReceita">

	<%@include file="NavBar.jsp"%>
	
	<% Usuario usuarioReceita = (Usuario) request.getAttribute("usuario"); %>
	<% Consulta consulta = (Consulta) request.getAttribute("consulta"); %>

	<h1 align="center">Adicionar Receita</h1>

	<form action="AdicionarReceita" method="post"
		style="width: 50%; margin-top: 8%; margin-left: 20%; border-style: inherit;">

		<table id="tblPrincipal" width="100%" cellspacing="0" cellpadding="5px" border="0">

			<tr>
				<td>

					<table id="tblCadastro" align="center">

						<tr>
							<td align="right">
								<label class="font-weight-bold">
									Data da	Consulta:
								</label>
							</td>
							
							<td align="left">
								<input class="form-control" type="date" size="10" <% if (consulta != null) { %>  value="<%=consulta.getData()%>" <%} %> var="txtDtConsulta" id="txtDtConsulta" name="txtDtConsulta" required />
							</td>	
							
						</tr>
							
						<tr>
							<td align="right">
								<label class="font-weight-bold">
									Horário da Consulta:
								</label>
							</td>
						
							<td class="final-btn">
								<select class="form-control" id="cbxHorario" name="cbxHorario" required style="width: 100%">
								<% if (consulta != null) { %>  
								<option value="<%= consulta.getHorario() %>" ><%= consulta.getHorario() %></option>
								<%} %>
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
								</select>
							</td>	
							
							<td align="left">
								<input class="btn btn-primary" type="submit" value="Verificar" />
							</td>					
						</tr>						

					</table>

				</td>
			</tr>
		</table>

		<%
			String msg = (String) request.getAttribute("msg");
			if (msg != null && msg.equals("Sucesso")) {
		%>

		<script>
					$(document).ready(function() {
					swal ('Sucesso', '', 'success' );
					});
		</script>
		<%
			} else if (msg != null) {
		%>
		<script>
					$(document).ready(function() {
					swal ('<%=msg%>', '', 'error');
			});
		</script>
		<%
			}
		%>

	</form>
	
	<% if(consulta != null) { %>
	
	<form action="ReceitaUpload?cdConsulta=<%=consulta.getCdConsulta()%>" method="POST" enctype="multipart/form-data" 
			style="width: 25%; margin-top: 5%; margin-left: 35%; border-style: inherit;">  
		<div style="text-align: center;" class="mb-3">
	  		<label class="form-label">Insira a Receita aqui:</label>
	  		<input class="form-control" type="file" name="arquivo">
		</div>
    						<input style="margin-left: 38%;" class="btn btn-primary" type="submit" value='enviar' >   
	</form> 	
						
	<% } %>

</body>
</html>