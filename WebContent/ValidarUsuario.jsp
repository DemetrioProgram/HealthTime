<%@page import="br.com.healthtime.entity.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
		integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
		crossorigin="anonymous"/>
<title>Insert title here</title>
</head>
<body>

	<%@include file="NavBar.jsp" %>
	
	<% 
		Usuario usuario = (Usuario) request.getAttribute("usuario");
	%>
	
	<form action="ValidaUsuario" method="post">

		<table id="tblPrincipal" border="1">

			<tr>
				<td>

					<h3 id="titulo" align="center">Valide o Usuário</h3>
					<table id="tblCadastro" align="center">

					
					
						<tr>
							<td align="right">
								<label class="fonte">CPF:</label>
							</td>
							
							<td align="left">
								<input type="text" name="txtNuCpf"  />
							</td>
							<td align="left">
							<input type="submit" value="Buscar Usuário" />
							</td>	
						</tr>
						
						<% if(usuario != null) { %>

						<tr>
							<td align="right"><label class="fonte">Nome:</label></td>
							<td align="left">
							<input type="text" size="70" name="txtNome" value="<%= usuario.getNome() %>" disabled
								required />
								</td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Data
									Nascimento:</label></td>
							<td align="left"><input type="date" name="txtDtNascimento" value="<%= usuario.getDtnascimento() %>" disabled
								required /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">E-mail:</label></td>
							<td align="left"><input type="text" name="txtEmail" value="<%= usuario.getEmail()%>" required disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Gestante:</label></td>
							<td align="left"><input type="checkbox" name="flGestante" value="<%= usuario.isFlGestante() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Idoso:</label></td>
							<td align="left"><input type="checkbox" name="flIdoso" value="<%= usuario.isFlIdoso() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Menor de
									Idade:</label></td>
							<td align="left"><input type="checkbox" name="flMenorIdade" value="<%= usuario.isFlMenorIdade() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Pessoa com
									Nessecidades Especiais:</label></td>
							<td align="left"><input type="checkbox" name="flPne" value="<%= usuario.isFlPne() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Nome da Mãe:</label>
							</td>
							<td align="left"><input type="text" name="txtNmMae" value="<%= usuario.getNomeMae() %>" required disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Tel. Contato:</label>
							</td>
							<td align="left"><input type="text" name="txtNuContato" value="<%= usuario.getNuContatoPrincipal() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Tel. Contato
									2:</label></td>
							<td align="left"><input type="text" name="txtNuContato2" value="<%= usuario.getNuContatoSecundario() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Número SUS:</label></td>
							<td align="left"><input type="text" name="txtNuSus" value="<%= usuario.getSus() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Logradouro:</label></td>
							<td align="left"><input type="text" size="70"
								name="txtNmRua" value="<%= usuario.getEndereco().getRua() %>" required disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Número:</label></td>
							<td align="left"><input type="text" size="6"
								name="txtNumero" value="<%= usuario.getEndereco().getNumero() %>" required disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Bairro:</label></td>
							<td align="left"><input type="text" name="txtBairro" value="<%= usuario.getEndereco().getBairro() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Cidade:</label></td>
							<td align="left"><input type="text" name="txtCidade" value="<%= usuario.getEndereco().getCidade() %>" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">UF</label></td>
							<td>
								<input type="text" id="cbxUf" name="cbxUf" value="<%= usuario.getEndereco().getUf() %>" required disabled >
							</td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">CEP:</label></td>
							<td align="left"><input type="text" name="txtCep" value="<%= usuario.getEndereco().getCep() %>" required disabled /></td>
						</tr>

						<tr>
							<td align="right"><label>Tipo de Usuário:</label></td>
							<td>
							<select id="comboUsuario" name="comboUsuario" align="left" > 
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
							<td width="965px" align="right"><input type="submit"
								value="Validar" /></td>
						</tr>
					</table>

				</td>
			</tr>
		</table>


	</form>

</body>
</html>