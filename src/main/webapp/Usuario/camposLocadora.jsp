<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<td><input type="text" id="nome" name="nome" size="50" required value="${Locadora != null ? Locadora.nome : ''}" /></td>
	</tr>
	<tr>
		<td><label for="email"><fmt:message key="user.email" /></label></td>
		<td><input type="text" id="email" name="email" size="50" required value="${Usuario != null ? Usuario.email : ''}" /></td>
	</tr>
	<tr>
		<td><label for="senha"><fmt:message key="user.pass" /></label></td>
		<td><input type="text" id="senha" name="senha" size="50" required value="${Usuario != null ? Usuario.senha : ''}" /></td>
	</tr>
	<tr>
		<td><label for="papel"><fmt:message key="user.role" /></label></td>
		<td><input type="text" id="papel" name="papel" size="20" required value="LOCADORA" readonly></td>
	</tr>
	<tr>
		<td><label for="descricao"><fmt:message key="user.description" /></label></td>
		<td><input type="text" id="descricao" name="descricao" size="120" required value="${Locadora != null ? Locadora.descricao : ''}" /></td>
	</tr>
	<tr>
		<td><label for="cnpj">CNPJ</label></td>
		<td><input type="text" id="cnpj" name="cnpj" size="14" required value="${Locadora != null ? Locadora.cnpj : ''}" /></td>
	</tr>
	<tr>
		<td><label for="cidade"><fmt:message key="user.city" /></label></td>
		<td><input type="text" id="cidade" name="cidade" size="14" required value="${Locadora != null ? Locadora.cidade : ''}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" onclick="validarFormulario()"/></td>
		<script>

			function validarEmail(email) {
  				var regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  				return regex.test(email);
			}

			function validarFormulario() {
				var email = document.getElementById("email").value;
				var senha = document.getElementById("senha").value;
				var papel = document.getElementById("papel").value;
				var nome = document.getElementById("nome").value;
				var descricao = document.getElementById("descricao").value;
				var cnpj = document.getElementById("cnpj").value;
				var cidade = document.getElementById("cidade").value;
				
  
				if (email === "") {
				  alert("O campo de E-mail está em branco!");
				  return false; // Impede o envio do formulário
				}
				if (!validarEmail(campoEmail)) {
    				alert("O campo de e-mail possui um formato inválido!");
    				return false; // Impede o envio do formulário
  				}
				if (nome === "") {
				  alert("O campo de Nome está em branco!");
				  return false; // Impede o envio do formulário
				}
				if (senha === "") {
				  alert("O campo de Senha está em branco!");
				  return false; // Impede o envio do formulário
				}
				if (cnpj === "") {
				  alert("O campo de CNPJ está em branco!");
				  return false; // Impede o envio do formulário
				}
				if (cidade === "") {
				  alert("O campo de Cidade está em branco!");
				  return false; // Impede o envio do formulário
				}
				return true; // Permite o envio do formulário
			}
		</script>
	</tr>
</table>
