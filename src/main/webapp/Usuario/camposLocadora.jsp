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
		<td><label for="nome">Nome</label></td>
		<td><input type="text" id="nome" name="nome" size="50"
			required value="${Locadora.nome}" /></td>
	</tr>
	<tr>
		<td><label for="email">Email</label></td>
		<td><input type="text" id="email" name="email" size="50" required
			value="${Usuario.email}" /></td>
	</tr>
	<tr>
		<td><label for="senha">Senha</label></td>
		<td><input type="text" id="senha" name="senha" size="50" required
			value="${Usuario.senha}" /></td>
	</tr>
	<tr>
		<td><label for="papel">Papel</label></td>
		<td><input type="text" id="papel" name="papel" size="20" required
			value="LOCADORA" readonly></td>
	</tr>
	<tr>
		<td><label for="descricao">Descricao</label></td>
		<td><input type="text" id="descricao" name="descricao" size="120" required
			value="${Locadora.descricao}" /></td>
	</tr>
	<tr>
		<td><label for="cnpj">CNPJ</label></td>
		<td><input type="text" id="cnpj" name="cnpj" size="14" required
			value="${Locadora.cnpj}" /></td>
	</tr>
	<tr>
		<td><label for="cidade">Cidade</label></td>
		<td><input type="text" id="cidade" name="cidade" size="14" required
			value="${Locadora.cidade}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
		<td colspan="2" align="center"><input type="button" name="limpar" value="Limpar" onclick="limparForm()"/></td>
		

		<script>
			function limparForm(){
				document.getElementById('id').value = "";
				document.getElementById('nome').value = "";
				document.getElementById('email').value = "";
				document.getElementById('senha').value = "";
				document.getElementById('papel').value = "";
				document.getElementById('descricao').value = "";
				document.getElementById('cnpj').value = "";
				document.getElementById('cidade').value = "";
			}
		</script>
	</tr>
</table>
