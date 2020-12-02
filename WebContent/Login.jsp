<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="resources/css/style.css">

<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<script src="resources/js/jquery-1.5.2.min.js"></script>
<script src="resources/js/combo.js"></script>
<script src="resources/js/jquery.maskedinput-1.3.min.js"></script>
<title>Insert title here</title>
</head>
<body onload="combo()">

	<div class="box-parent-login" style="margin-left: 30%; margin-right: 30%; margin-top: 10%">
	
		<div class="well bg-white box-login">
		
			<h1 class="ls-login-logo" style="text-align: center;">
				Bem vindo(a) ao Health Time.
			</h1>
			
			<form role="form" action="Login" method="post">
			
				<fieldset>

					<div class="form-group ls-login-user">
					
						<label>CPF</label> 
						
						<input	class="form-control ls-login-bg-user input-lg" id="cpf"
							aria-label="CPF" name="txtCpf" placeholder="CPF" type="text">


						<label class="fonte">Unidade:</label>
						
						<div class="custom-select">
							<select id="cbxMedico" name="cbxMedico" required>
								<option value="">Selecione</option>

								<c:forEach var="unidade" items="${unidades}">
									<option value="${unidade.nmunidade}">${unidade.nmunidade}</option>
								</c:forEach>

							</select>
						</div>
						
					</div>

					<input value="Entrar" class="btn btn-primary btn-lg btn-block"	type="submit">
					
					<span class="psw">Ainda não sou <a href="CadastroUsuario">cadastrado</a>.</span>

					<%
						Exception erro = (Exception) request.getAttribute("erro");
						if (erro != null) {
					%>
					<!--  <div class="alert alert-danger" role="alert"
						style="text-align: center; margin-top: 10px;">
						<span></span>
					</div> -->
					<script>
					$(document).ready(function() {
					swal ('<%=erro.getMessage()%>', '', 'error' );
					});
					</script>
					<%
						}
					%>

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