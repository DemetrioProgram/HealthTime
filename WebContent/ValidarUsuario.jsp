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
								<input type="text" name="txtNuCpf" required />
							</td>
							<td align="left">
							<input type="submit" value="Buscar Usuário" />
							</td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Nome:</label></td>
							<td align="left"><input type="text" size="70" name="txtNome" disabled
								required /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Data
									Nascimento:</label></td>
							<td align="left"><input type="text" name="txtDtNascimento" disabled
								required /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">E-mail:</label></td>
							<td align="left"><input type="text" name="txtEmail" required disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Gestante:</label></td>
							<td align="left"><input type="checkbox" name="flGestante" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Idoso:</label></td>
							<td align="left"><input type="checkbox" name="flIdoso" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Menor de
									Idade:</label></td>
							<td align="left"><input type="checkbox" name="flMenorIdade" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Pessoa com
									Nessecidades Especiais:</label></td>
							<td align="left"><input type="checkbox" name="flPne" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Nome da Mãe:</label>
							</td>
							<td align="left"><input type="text" name="txtNmMae" required disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Tel. Contato:</label>
							</td>
							<td align="left"><input type="text" name="txtNuContato" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Tel. Contato
									2:</label></td>
							<td align="left"><input type="text" name="txtNuContato2" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Número SUS:</label></td>
							<td align="left"><input type="text" name="txtNuSus" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Logradouro:</label></td>
							<td align="left"><input type="text" size="70"
								name="txtNmRua" required disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Número:</label></td>
							<td align="left"><input type="text" size="6"
								name="txtNumero" required disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Bairro:</label></td>
							<td align="left"><input type="text" name="txtBairro" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Cidade:</label></td>
							<td align="left"><input type="text" name="txtCidade" disabled /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">UF</label></td>
							<td>
								<input type="text" id="cbxUf" name="cbxUf" required disabled >
							</td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">CEP:</label></td>
							<td align="left"><input type="text" name="txtCep" required disabled /></td>
						</tr>

						<tr>
							<td></td>
						</tr>
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