<%@page import="br.com.healthtime.entity.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
		integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
		crossorigin="anonymous"/>
<script src="resources/js/jquery-1.5.2.min.js"></script>
<script src="resources/js/jquery.maskedinput-1.3.min.js"></script>
<title>Validar Usu�rio</title>
</head>
<body id="validaUsuario">

	<%@include file="NavBar.jsp" %>
	
	<% 
		Usuario usuarioValidar = (Usuario) request.getAttribute("usuario");
	%>
	<h1 align="center">Valide o Usu�rio</h1>
	
	<form action="ValidaUsuario" method="post">

		<table id="tblPrincipal" width="100%" cellspacing="0" cellpadding="5px" border="0">

			<tr>
				<td>

					<table id="tblCadastro" align="center">
					
						<tr>
							<td align="right">
							</td>
							
							<td class="final-btn" align="left">
								<input class="form-control" id="cpf" placeholder="Digite o CPF" type="text" name="txtNuCpf"  />
							</td>
							<td align="left">
							<input class="btn btn-primary" type="submit" value="Buscar Usu�rio" />
							</td>	
						</tr>
						
						<% if(usuarioValidar != null) { %>

						<tr>
							<td align="right"><label class="font-weight-bold">Nome:</label></td>
							<td align="left">
							<input class="form-control" type="text" size="70" name="txtNome" value="<%= usuarioValidar.getNome() %>" disabled
								required />
								</td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Data
									Nascimento:</label></td>
							<td align="left"><input class="form-control" type="date" name="txtDtNascimento" value="<%= usuarioValidar.getDtnascimento() %>" disabled
								required /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">E-mail:</label></td>
							<td align="left"><input class="form-control" type="text" name="txtEmail" value="<%= usuarioValidar.getEmail()%>" required disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Gestante:</label></td>
							<td align="left"><input type="checkbox" name="flGestante" value="<%= usuarioValidar.isFlGestante() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Idoso:</label></td>
							<td align="left"><input type="checkbox" name="flIdoso" value="<%= usuarioValidar.isFlIdoso() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Menor de
									Idade:</label></td>
							<td align="left"><input type="checkbox" name="flMenorIdade" value="<%= usuarioValidar.isFlMenorIdade() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Pessoa com
									Nessecidades Especiais:</label></td>
							<td align="left"><input type="checkbox" name="flPne" value="<%= usuarioValidar.isFlPne() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Nome da M�e:</label>
							</td>
							<td align="left"><input class="form-control" type="text" name="txtNmMae" value="<%= usuarioValidar.getNomeMae() %>" required disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Tel. Contato:</label>
							</td>
							<td align="left"><input class="form-control" type="text" name="txtNuContato" value="<%= usuarioValidar.getNuContatoPrincipal() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Tel. Contato
									2:</label></td>
							<td align="left"><input class="form-control" type="text" name="txtNuContato2" value="<%= usuarioValidar.getNuContatoSecundario() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">N�mero SUS:</label></td>
							<td align="left"><input class="form-control" type="text" name="txtNuSus" value="<%= usuarioValidar.getSus() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Logradouro:</label></td>
							<td align="left"><input class="form-control" type="text" size="70"
								name="txtNmRua" value="<%= usuarioValidar.getEndereco().getRua() %>" required disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">N�mero:</label></td>
							<td align="left"><input class="form-control" type="text" size="6"
								name="txtNumero" value="<%= usuarioValidar.getEndereco().getNumero() %>" required disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Bairro:</label></td>
							<td align="left"><input class="form-control" type="text" name="txtBairro" value="<%= usuarioValidar.getEndereco().getBairro() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Cidade:</label></td>
							<td align="left"><input class="form-control" type="text" name="txtCidade" value="<%= usuarioValidar.getEndereco().getCidade() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">UF</label></td>
							<td>
								<input class="form-control" type="text" id="cbxUf" name="cbxUf" value="<%= usuarioValidar.getEndereco().getUf() %>" required disabled >
							</td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">CEP:</label></td>
							<td align="left"><input class="form-control" type="text" name="txtCep" value="<%= usuarioValidar.getEndereco().getCep() %>" required disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Tipo de Usu�rio:</label></td>
							<td>
							<select class="form-control" id="comboUsuario" name="comboUsuario" align="left" > 
								<option value="">Selecione</option>
								<option value="1">Paciente</option>
								<option value="2">M�dico</option>
								<option value="3">Funcion�rio</option>
							</select>
							</td>
						</tr>
						
						<% } %>
					</table>



					<table id="tblBotao">
						<tr>
							<td class="final-btn" width="965px" align="right">
								<input class="btn btn-primary btn-lg" type="submit" value="Validar" />
							</td>
						</tr>
					</table>

				</td>
			</tr>
		</table>


	</form>
	
		<script>
		jQuery(function($) {
			$("#cpf").mask("999.999.999-99");

		});
	</script>

</body>
</html>