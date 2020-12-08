<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Cadastrar Usuario</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous" />
<script src="resources/js/jquery-1.5.2.min.js"></script>
<script src="resources/js/jquery.maskedinput-1.3.min.js"></script>
</head>


<body id="cadastroUsuario">
	
	<h1 align="center" style="margin-top: 5%">Efetue seu Cadastro</h1	>

	<form action="CadastroUsuario" method="post" style="width: 50%; margin-top: 8%; margin-left: 20%; border-style: inherit;">

		<table id="tblPrincipal" cellspacing="0" cellpadding="5px" border="0">

			<tr>
				<td>

					<table id="tblCadastro" align="center">

						<tr>
							<td align="right">
								<label class=" font-weight-bold">Nome:</label>
							</td>
							
							<td align="left">
								<input class="form-control" type="text" size="70" name="txtNome"	required />
							</td>
						</tr>

						<tr>
							<td align="right">
								<label class=" font-weight-bold">CPF:</label>
							</td>
							
							<td align="left">
								<input class="form-control" type="text" id="cpf" size="20" name="txtNuCpf" required />
							</td>
						</tr>

						<tr>
							<td align="right">
								<label class=" font-weight-bold">Data Nascimento:</label>
							</td>
							
							<td align="left">
								<input class="form-control" type="text" name="txtDtNascimento" id="data" required />
							</td>
						</tr>

						<tr>
							<td align="right">
								<label class=" font-weight-bold">E-mail:</label>
							</td>
							
							<td align="left">
								<input class="form-control" type="email" name="txtEmail"	required />
							</td>
						</tr>

						<tr>
							<td align="right">
								<label class=" font-weight-bold">Gestante:</label>
							</td>
							
							<td align="left">
								<input type="checkbox" value="true" name="flGestante" />
							</td>
						</tr>

						<tr>
							<td align="right">
								<label class=" font-weight-bold">Idoso:</label>
							</td>
							
							<td align="left">
								<input type="checkbox" value="true"	name="flIdoso" />
							</td>
						</tr>

						<tr>
							<td align="right">
								<label class=" font-weight-bold">Menor de Idade:</label>
							</td>
							
							<td align="left">
								<input type="checkbox" value="true"	name="flMenorIdade" />
							</td>
						</tr>

						<tr>
							<td align="right">
								<label class=" font-weight-bold">Pessoa com	Nessecidades Especiais:</label>
							</td>
							
							<td align="left">
								<input type="checkbox" value="true"	name="flPne" />
							</td>
						</tr>

						<tr>
							<td align="right">
								<label class=" font-weight-bold">Nome da Mãe:</label>
							</td>
							
							<td align="left">
								<input class="form-control" type="text" name="txtNmMae" required />
							</td>
						</tr>

						<tr>
							<td align="right">
								<label class=" font-weight-bold">Tel. Celular:</label>
							</td>
							
							<td align="left">
								<input class="form-control" type="text" id="telefone" name="txtNuContato" />
							</td>
						</tr>

						<tr>
							<td align="right">
								<label class=" font-weight-bold">Tel. Residêncial:</label>
							</td>
							
							<td align="left">
								<input class="form-control" type="text" id="telefone2" name="txtNuContato2" />
							</td>
						</tr>

						<tr>
							<td align="right">
								<label class=" font-weight-bold">Número SUS:</label>
							</td>
							
							<td align="left">
								<input class="form-control" type="text" name="txtNuSus" />
							</td>
						</tr>

						<tr>
							<td align="right">
								<label class=" font-weight-bold">Unidade SUS:</label>
							</td>
							
							<td>
									<select class="form-control" id="cbxUnudade" name="cbxUnidade" required>
										<option value="">Selecione</option>

										<c:forEach var="unidade" items="${unidades}">
											<option value="${unidade.cdUnidade}">
												${unidade.nmunidade}</option>
										</c:forEach>

									</select>
							</td>
						</tr>

						<tr>
							<td align="right">
								<label class=" font-weight-bold">Logradouro:</label>
							</td>
							
							<td align="left">
								<input class="form-control" type="text" size="70" name="txtNmRua" required />
							</td>
						</tr>

						<tr>
							<td align="right">
								<label class=" font-weight-bold">Número:</label>
							</td>
							
							<td align="left">
								<input class="form-control" type="number" size="6"	name="txtNumero" required />
							</td>
						</tr>

						<tr>
							<td align="right">
								<label class=" font-weight-bold">Bairro:</label>
							</td>
							
							<td align="left">
								<input class="form-control" type="text" name="txtBairro" />
							</td>
						</tr>

						<tr>
							<td align="right">
								<label class=" font-weight-bold">Cidade:</label>
							</td>
							
							<td align="left">
								<input class="form-control" type="text" name="txtCidade" />
							</td>
						</tr>

						<tr>
							<td align="right"><label class=" font-weight-bold">UF:</label></td>
							<td>
									<select class="form-control" id="cbxUf" name="cbxUf" required>
										<option value="">Nenhuma</option>
										<option value="SC">SC</option>
										<option value="RS">RS</option>
										<option value="SP">SP</option>
										<option value="RJ">RJ</option>
										<option value="MA">MA</option>
									</select>
							</td>
						</tr>

						<tr>
							<td align="right">
								<label class=" font-weight-bold">CEP:</label>
							</td>
							
							<td align="left">
								<input class="form-control" type="text" id="cep" name="txtCep" required />
							</td>
						</tr>

						<tr>
							<td></td>
						</tr>
					</table> <script>
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
							<td class="final-btn" width="965px" align="center">
								<input class="btn btn-primary btn-lg" type="submit" value="Vamos Lá" />
							</td>
						</tr>
					</table>

				</td>
			</tr>
		</table>


	</form>

</body>
</html>