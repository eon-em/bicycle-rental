<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table border="1">
	<caption>
		<c:choose>
			<c:when test="${bicicleta != null}">
                            Edição
                        </c:when>
			<c:otherwise>
                            Cadastro
                        </c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${bicicleta != null}">
		<input type="hidden" name="id" value="${bicicleta.id}" />
	</c:if>
	<tr>
		<td><label for="locadora">Locadora</label></td>
		<td>
			<select id="locadora" name="locadora" required>
				<c:forEach var="locadora" items="${requestScope.locadoras}">
					<option value="${locadora.nome}">${locadora.nome}</option>
				</c:forEach>
			</select>
		</td>
	</tr>	
	<tr>
		<td><label for="dataLocacao">Data de Locação {yyyy-MM-dd}</label></td>
		<td><input type="date" id="dataLocacao" name="dataLocacao"
			required value="${bicicleta.dataLocacao}"/></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
		<td colspan="2" align="center"><input type="button" name="limpar" value="Limpar" onclick="limparForm()"/></td>
		

		<script>
			function limparForm(){
				document.getElementById('locadora').value = "";
				document.getElementById('datalocacao').value = "";
			}

		</script>
	</tr>
</table>
