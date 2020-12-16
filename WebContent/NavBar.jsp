<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="br.com.healthtime.entity.Usuario"%>
	<%@page import="br.com.healthtime.entity.Gestor"%>
<!DOCTYPE html>
<header>

	<% 
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		Gestor gestor = (Gestor) session.getAttribute("gestor");
	%>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		
		<a class="navbar-brand" href="#">Health Time</a>
		
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
			aria-expanded="false" aria-label="Toggle navigation">
			
			<span class="navbar-toggler-icon"></span>
			
		</button>
		
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		
			<div class="navbar-nav">
				
				<a class="nav-link active font-weight-bold" href="Principal.jsp">
					Inicio
				</a> 
				
				<a class="nav-link font-weight-bold" href="AgendarConsulta.jsp">
					Agendar Consulta
				</a> 
				
				<a class="nav-link font-weight-bold" href="CancelarConsulta.jsp">
					Cancelar Consulta
				</a> 
					
					<%if(usuario != null && usuario.getCodigo() != 1) {%>
					
				<a class="nav-link font-weight-bold" href="CadastroConsulta">
					Cadastrar Consulta
				</a> 
					
					<%}%>
					
					<%if(usuario != null && usuario.getCodigo() == 2) {%>
					
				<a class="nav-link font-weight-bold" href="AdicionarReceita.jsp">
					Adicionar Receita
				</a> 
					
					<%}%>
					
					<%if(gestor != null) {%>
									
				
				<a class="nav-link font-weight-bold" href="ValidarUsuario.jsp">
					Validar Usuário
				</a>
								
				<%}%>
				
			</div>
		</div>

		<a class="nav-link font-weight-bold" href="#">
					Sair
		</a>
		
		<img
			src="resources/img/logo.png" width="3%"/>
	</nav>

</header>