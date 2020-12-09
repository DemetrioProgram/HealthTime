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
<title>Validar Usuário</title>
</head>
<body id="validaUsuario">

	<%@include file="NavBar.jsp" %>
	
	<% 
		Usuario usuarioLogado = (Usuario) request.getAttribute("usuario");
	%>
	<h1 align="center">Valide o Usuário</h1>
	
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
							<input class="btn btn-primary" type="submit" value="Buscar Usuário" />
							</td>	
						</tr>
						
						<% if(usuarioLogado != null) { %>

						<tr>
							<td align="right"><label class="font-weight-bold">Nome:</label></td>
							<td align="left">
							<input class="form-control" type="text" size="70" name="txtNome" value="<%= usuario.getNome() %>" disabled
								required />
								</td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Data
									Nascimento:</label></td>
							<td align="left"><input class="form-control" type="date" name="txtDtNascimento" value="<%= usuario.getDtnascimento() %>" disabled
								required /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">E-mail:</label></td>
							<td align="left"><input class="form-control" type="text" name="txtEmail" value="<%= usuario.getEmail()%>" required disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Gestante:</label></td>
							<td align="left"><input type="checkbox" name="flGestante" value="<%= usuario.isFlGestante() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Idoso:</label></td>
							<td align="left"><input type="checkbox" name="flIdoso" value="<%= usuario.isFlIdoso() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Menor de
									Idade:</label></td>
							<td align="left"><input type="checkbox" name="flMenorIdade" value="<%= usuario.isFlMenorIdade() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Pessoa com
									Nessecidades Especiais:</label></td>
							<td align="left"><input type="checkbox" name="flPne" value="<%= usuario.isFlPne() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Nome da Mãe:</label>
							</td>
							<td align="left"><input class="form-control" type="text" name="txtNmMae" value="<%= usuario.getNomeMae() %>" required disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Tel. Contato:</label>
							</td>
							<td align="left"><input class="form-control" type="text" name="txtNuContato" value="<%= usuario.getNuContatoPrincipal() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Tel. Contato
									2:</label></td>
							<td align="left"><input class="form-control" type="text" name="txtNuContato2" value="<%= usuario.getNuContatoSecundario() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Número SUS:</label></td>
							<td align="left"><input class="form-control" type="text" name="txtNuSus" value="<%= usuario.getSus() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Logradouro:</label></td>
							<td align="left"><input class="form-control" type="text" size="70"
								name="txtNmRua" value="<%= usuario.getEndereco().getRua() %>" required disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Número:</label></td>
							<td align="left"><input class="form-control" type="text" size="6"
								name="txtNumero" value="<%= usuario.getEndereco().getNumero() %>" required disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Bairro:</label></td>
							<td align="left"><input class="form-control" type="text" name="txtBairro" value="<%= usuario.getEndereco().getBairro() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Cidade:</label></td>
							<td align="left"><input class="form-control" type="text" name="txtCidade" value="<%= usuario.getEndereco().getCidade() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">UF</label></td>
							<td>
								<input class="form-control" type="text" id="cbxUf" name="cbxUf" value="<%= usuario.getEndereco().getUf() %>" required disabled >
							</td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">CEP:</label></td>
							<td align="left"><input class="form-control" type="text" name="txtCep" value="<%= usuario.getEndereco().getCep() %>" required disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="font-weight-bold">Tipo de Usuário:</label></td>
							<td>
							<select class="form-control" id="comboUsuario" name="comboUsuario" align="left" > 
								<option value="">Selecione</option>
								<option value="1">Paciente</option>
								<option value="2">Médico</option>
								<option value="3">Funcionário</option>
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