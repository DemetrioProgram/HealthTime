<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.css">
	
	<script
	src="resources/js/jquery-1.5.2.min.js"></script>
	<script src="resources/js/jquery.maskedinput-1.3.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<div class="box-parent-login"
		style="margin-left: 30%; margin-right: 30%; margin-top: 10%">
		<div class="well bg-white box-login">
				<h1 class="ls-login-logo" style="text-align: center;">
					Bem	vindo(a) ao Health Time.
				</h1>
			<form role="form" action="Login" method="post">
				<fieldset>

					<div class="form-group ls-login-user">
						<label>CPF</label> 
							<input
							class="form-control ls-login-bg-user input-lg" id="cpf"
							aria-label="CPF" name="txtCpf" placeholder="CPF" type="text">
					</div>

					<input value="Entrar" class="btn btn-primary btn-lg btn-block"
						type="submit">
						
						<% 
						Exception erro = (Exception) request.getAttribute("erro");
						if (erro != null) {
							
							%>
						<div class="alert alert-danger" role="alert" style="text-align: center;margin-top: 10px;">
							<span><%= erro.getMessage() %></span>
						</div>
						<% } %>

				</fieldset>
			</form>
		</div>
	</div>
	
	<script>
						jQuery(function($) {
							$("#cpf").mask("999.999.999-99");
							
						});
					</script>

</body>
</html>