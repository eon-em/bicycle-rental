<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="message_pt" />

<table border="1">
	<caption>
		<c:choose>
			<c:when test="${Usuario != null}">
							<fmt:message key="user.edit" />:
                        </c:when>
			<c:otherwise>
							<fmt:message key="user.reg" />:
                        </c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${Usuario != null}">
		<input type="hidden" name="id" value="${Usuario.id}" />
	</c:if>
	<tr>
		<td><label for="nome"><fmt:message key="user.name" /></label></td>
		<td><input type="text" id="nome" name="nome" size="50"
			required value="${Cliente.nome}" /></td>
	</tr>
	<tr>
		<td><label for="email"><fmt:message key="user.email" /></label></td>
		<td><input type="text" id="email" name="email" size="50" required
			value="${Usuario.email}" /></td>
	</tr>
	<tr>
		<td><label for="senha"><fmt:message key="user.pass" /></label></td>
		<td><input type="text" id="senha" name="senha" size="50" required
			value="${Usuario.senha}" /></td>
	</tr>
	<tr>
		<td><label for="papel"><fmt:message key="user.role" /></label></td>
		<td><input type="text" id="papel" name="papel" size="20" required
			value="CLIENTE" readonly></td>	
	</tr>
	<tr>
		<td><label for="cpf">cpf</label></td>
		<td><input type="text" id="cpf" name="cpf" size="14" required
			value="${Cliente.cpf}" /></td>
	</tr>
	<tr>
		<td><label for="telefone"><fmt:message key="user.phone" /></label></td>
		<td><input type="text" id="telefone" name="telefone" size="11" required
			value="${Cliente.telefone}" /></td>
	</tr>
	<tr>
		<td><label for="sexo"><fmt:message key="user.sex" /></label></td>
		<td><input type="text" id="sexo" name="sexo" size="1" required
			value="${Cliente.sexo}" /></td>
	</tr>
	<tr>
		<td><label for="dataDeNascimento"><fmt:message key="user.birth" /></label></td>
		<td><input type="date" id="dataDeNascimento" name="dataDeNascimento"  required
			value="${Cliente.dataDeNascimento}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" onclick="validarFormulario()"/></td>
		<script>

			function validarEmail(email) {
  				var regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  				return regex.test(email);
			}
			function validarSexo(sexo) {
  				return sexo === "M" || sexo === "F";
			}
			function validarDataNascimento(data) {
				var regex = /^\d{2}\/\d{2}\/\d{4}$/;
				
				if (!regex.test(data)) {
				  return false; // Formato inválido de data (dd/mm/yyyy)
				}
				
				var partes = data.split('/');
				var dia = parseInt(partes[0], 10);
				var mes = parseInt(partes[1], 10);
				var ano = parseInt(partes[2], 10);
				
				if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || ano < 1900 || ano > new Date().getFullYear()) {
				  return false; // Data inválida
				}
				
				var dataNascimento = new Date(ano, mes - 1, dia);
				
				if (dataNascimento.getDate() !== dia || dataNascimento.getMonth() !== (mes - 1) || dataNascimento.getFullYear() !== ano) {
				  return false; // Data inválida (por exemplo, 31 de fevereiro)
				}
				
				return true; // Data de nascimento válida
			}
			
			function validarFormulario() {
				var email = document.getElementById("email").value;
				var senha = document.getElementById("senha").value;
				var papel = document.getElementById("papel").value;
				var nome = document.getElementById("nome").value;
				var cpf = document.getElementById("cpf").value;
				var telefone = document.getElementById("telefone").value;
				var sexo = document.getElementById("sexo").value;
				var data = document.getElementById("dataDeNascimento").value;
  
				if (email === "") {
				  alert("O campo de E-mail está em branco!");
				  return false; // Impede o envio do formulário
				}
				if (!validarEmail(email)) {
    				alert("O campo de e-mail possui um formato inválido!");
    				return false; // Impede o envio do formulário
  				}
				if (nome === "") {
				  alert("O campo de Usuário está em branco!");
				  return false; // Impede o envio do formulário
				}
				if (senha === "") {
				  alert("O campo de Senha está em branco!");
				  return false; // Impede o envio do formulário
				}
				if (papel === "") {
				  alert("O campo de Papel está em branco!");
				  return false; // Impede o envio do formulário
				}
				if (cpf === "") {
				  alert("O campo de Senha está em branco!");
				  return false; // Impede o envio do formulário
				}
				if (telefone === "") {
				  alert("O campo de Papel está em branco!");
				  return false; // Impede o envio do formulário
				}
				if (!validarSexo(sexo)) {
    				alert("O campo de sexo possui um valor inválido! Digite M ou F!");
    				return false; // Impede o envio do formulário
  				}
				if (sexo === "") {
				  alert("O campo de Senha está em branco!");
				  return false; // Impede o envio do formulário
				}
				if (data === "") {
				  alert("O campo de Papel está em branco!");
				  return false; // Impede o envio do formulário
				}
				if (!validarDataNascimento(data)) {
    				alert("O campo de data de nascimento possui uma data inválida!");
    				return false; // Impede o envio do formulário
  				}
				return true; // Permite o envio do formulário
			}
		</script>
	</tr>
</table>
