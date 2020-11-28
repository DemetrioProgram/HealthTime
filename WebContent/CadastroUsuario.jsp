<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Cadastrar Usuario</title>
<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
		integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
		crossorigin="anonymous"/>
<script
	src="resources/js/jquery-1.5.2.min.js"></script>
	<script src="resources/js/jquery.maskedinput-1.3.min.js"></script>
</head>


<body>

	<%@include file="NavBar.jsp" %>

	<form action="CadastroUsuario" method="post">

		<table id="tblPrincipal" border="1">

			<tr>
				<td>

					<h3 id="titulo" align="center">Efetue seu Cadastro</h3>
					<table id="tblCadastro" align="center">

						<tr>
							<td align="right"><label class="fonte">Nome:</label></td>
							<td align="left"><input type="text" size="70" name="txtNome"
								required /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">CPF:</label></td>
							<td align="left"><input type="text" id="cpf" size="20"
								name="txtNuCpf" required /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Data
									Nascimento:</label></td>
							<td align="left"><input type="text" name="txtDtNascimento" id="data"
								required /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">E-mail:</label></td>
							<td align="left"><input type="text" name="txtEmail" required /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Gestante:</label></td>
							<td align="left"><input type="checkbox" value="true" name="flGestante" /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Idoso:</label></td>
							<td align="left"><input type="checkbox" value="true" name="flIdoso" /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Menor de
									Idade:</label></td>
							<td align="left"><input type="checkbox" value="true" name="flMenorIdade" /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Pessoa com
									Nessecidades Especiais:</label></td>
							<td align="left"><input type="checkbox" value="true" name="flPne" /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Nome da Mãe:</label>
							</td>
							<td align="left"><input type="text" name="txtNmMae" required /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Tel. Contato:</label>
							</td>
							<td align="left"><input type="text" id="telefone" name="txtNuContato" /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Tel. Contato
									2:</label></td>
							<td align="left"><input type="text" id="telefone2" name="txtNuContato2" /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Número SUS:</label></td>
							<td align="left"><input type="text" name="txtNuSus" /></td>
						</tr>
						
						<tr>
						<td align="right"><label class="fonte">Unidade SUS:</label></td>
							<td>
							
								<select id="cbxUnudade" name="cbxUnidade" required>
									<option value="">Selecione</option>
							
										<c:forEach var="unidade" items="${unidades}">
											<option value="${unidade.cdUnidade}">
												${unidade.nmunidade}
											</option>
										</c:forEach>
							
								</select>
							</td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Logradouro:</label></td>
							<td align="left"><input type="text" size="70"
								name="txtNmRua" required /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Número:</label></td>
							<td align="left"><input type="text" size="6"
								name="txtNumero" required /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Bairro:</label></td>
							<td align="left"><input type="text" name="txtBairro" /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Cidade:</label></td>
							<td align="left"><input type="text" name="txtCidade" /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">UF</label></td>
							<td><select id="cbxUf" name="cbxUf" required>
									<option value="">Nenhuma</option>
									<option value="SC">SC</option>
									<option value="RS">RS</option>
									<option value="SP">SP</option>
									<option value="RJ">RJ</option>
									<option value="MA">MA</option>
							</select></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">CEP:</label></td>
							<td align="left"><input type="text" id="cep" name="txtCep" required /></td>
						</tr>

						<tr>
							<td></td>
						</tr>
					</table>
					
					<script>
						jQuery(function($) {
							$("#cpf").mask("999.999.999-99");
							$("#telefone").mask("(99) 99999-9999");
							$("#telefone2").mask("(99) 9999-9999");
							$("#cep").mask("99999-999");
							$("#data").mask("99/99/9999");
						});
					</script>

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