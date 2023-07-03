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
		<td><label for="cliente">ID Cliente</label></td>
		<td><input type="text" id="cliente" name="cliente" size="45"
			required value="${bicicleta.clienteId}" readonly/></td>
	</tr>
	<tr>
		<td><label for="locadora">ID Locadora</label></td>
		<td><input type="text" id="locadora" name="locadora" size="45"
			required value="${bicicleta.locadoraId}" readonly/></td>
	</tr>
	<tr>
		<td><label for="dataLocacao">Data de Locação {yyyy-MM-dd}</label></td>
		<td><input type="date" id="dataLocacao" name="dataLocacao"
			required value="${bicicleta.dataLocacao}" readonly/></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
	</tr>
</table>