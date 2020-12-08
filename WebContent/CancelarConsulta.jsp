<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="br.com.healthtime.entity.Consulta"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous" />
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>
<script
	src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Cancelar Consulta</title>
</head>
<body id="CancelarConsulta">

	<%@include file="NavBar.jsp"%>
	
	<% Consulta consulta = (Consulta) request.getAttribute("consulta"); %>

	<h1 align="center">Cancelar Consulta</h1>

	<form action="CancelarConsulta" method="post"
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
								<input class="form-control" type="date" size="10" var="txtDtConsulta" id="txtDtConsulta" name="txtDtConsulta" required />
							</td>	
							
							<td align="left">
							<input class="btn btn-primary" type="submit" value="Verificar" />
							</td>						
						</tr>						

						<% if(consulta != null) { %>

						<tr>
							<td align="right">
								<label class="font-weight-bold">
									Consulta Agendada:
								</label>
							</td>
							
							<td>
								<input class="form-control" type="text" size="10" name="txtHorario" value="<%= consulta.getHorario() %>" disabled/>
							</td>
						</tr>						

						<% } %>
					</table>



					<table>
						<tr>
							<td class="final-btn" width="965px" align="center">
								<input class="btn btn-primary btn-lg" type="submit" value="Cancelar" />
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

</body>
</html>