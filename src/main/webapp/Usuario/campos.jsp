<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="bundleName" value="${empty param.locale || param.locale eq 'pt' ? 'message_pt' : 'message_en'}" />
<fmt:setBundle basename="${bundleName}" />

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
		<td><label for="email"><fmt:message key="user.email" /></label></td>
		<td><input type="text" id="email" name="email" size="45" required
			value="${Usuario.email}" /></td>
	</tr>
	<tr>
		<td><label for="senha"><fmt:message key="user.pass" /></label></td>
		<td><input type="text" id="senha" name="senha" size="45" required
			value="${Usuario.senha}" /></td>
	</tr>
	<tr>
		<td><label for="papel"><fmt:message key="user.role" /></label></td>
		<td><input type="text" id="papel" name="papel" size="20" required
			value="ADMIN" readonly></td>	
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" onclick="validarFormulario()"/></td>
		<script>
			function validarFormulario() {
				var email = document.getElementById("email").value;
				var senha = document.getElementById("senha").value;
				var papel = document.getElementById("papel").value;
				var id = document.getElementById("id").value;
  
				if (email === "") {
				  alert("O campo de E-mail está em branco!");
				  return false; // Impede o envio do formulário
				}
				if (id === "") {
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
				return true; // Permite o envio do formulário
			}
		</script>
}
	</tr>
</table>
