<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table border="1">
	<caption>
		<c:choose>
			<c:when test="${Usuario != null}">
                            Edição
                        </c:when>
			<c:otherwise>
                            Cadastro
                        </c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${Usuario != null}">
		<input type="hidden" name="id" value="${Usuario.id}" />
	</c:if>
	<tr>
		<td><label for="email">Email</label></td>
		<td><input type="text" id="email" name="email" size="45" required
			value="${Usuario.email}" /></td>
	</tr>
	<tr>
		<td><label for="senha">Senha</label></td>
		<td><input type="text" id="senha" name="senha" size="45" required
			value="${Usuario.senha}" /></td>
	</tr>
	<tr>
		<td><label for="papel">Papel</label></td>
		<td><input type="text" id="papel" name="papel" size="20" required
			value="ADMIN" readonly></td>	
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
		<td colspan="2" align="center"><input type="button" name="limpar" value="Limpar" onclick="limparForm()"/></td>
		

		<script>
			function limparForm(){
				document.getElementById('email').value = "";
				document.getElementById('senha').value = "";
				document.getElementById('papel').value = "";
				document.getElementById('id').value = "";
			}
	</tr>
</table>
