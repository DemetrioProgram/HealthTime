<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Cadastrar Usuario</title>
</head>


<body>


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
							<td align="left"><input type="text" size="20"
								name="txtNuCpf" required /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Data
									Nascimento:</label></td>
							<td align="left"><input type="text" name="txtDtNascimento"
								required /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">E-mail:</label></td>
							<td align="left"><input type="text" name="txtEmail" required /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Gestante:</label></td>
							<td align="left"><input type="checkbox" name="flGestante" /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Idoso:</label></td>
							<td align="left"><input type="checkbox" name="flIdoso" /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Menor de
									Idade:</label></td>
							<td align="left"><input type="checkbox" name="flMenorIdade" /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Pessoa com
									Nessecidades Especiais:</label></td>
							<td align="left"><input type="checkbox" name="flPne" /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Nome da Mãe:</label>
							</td>
							<td align="left"><input type="text" name="txtNmMae" reuired /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Tel. Contato:</label>
							</td>
							<td align="left"><input type="text" name="txtNuContato" /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Tel. Contato
									2:</label></td>
							<td align="left"><input type="text" name="txtNuContato2" /></td>
						</tr>

						<tr>
							<td align="right"><label class="fonte">Número SUS:</label></td>
							<td align="left"><input type="text" name="txtNuSus" /></td>
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
							<td align="left"><input type="text" name="txtCep" required /></td>
						</tr>

						<tr>
							<td></td>
						</tr>
					</table>



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