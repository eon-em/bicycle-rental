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
		<td><label for="placa">Placa</label></td>
		<td><input type="text" id="placa" name="placa" size="45" required
			value="${bicicleta.placa}" /></td>
	</tr>
	<tr>
		<td><label for="modelo">Modelo</label></td>
		<td><input type="text" id="modelo" name="modelo" size="45"
			required value="${bicicleta.modelo}" /></td>
	</tr>
	<tr>
		<td><label for="chassi">Chassi</label></td>
		<td><input type="text" id="chassi" name="chassi" size="45"
			required value="${bicicleta.chassi}" /></td>
	</tr>
	<tr>
		<td><label for="locadora">ID Locadora</label></td>
		<td><input type="text" id="locadora" name="locadora" size="45"
			required value="${Usuario.id}" readonly/></td>
	</tr>
	<tr>
		<td><label for="ano">Ano</label></td>
		<td><input type="number" id="ano" name="ano" size="4" required
			min="1500" value="${bicicleta.ano}" /></td>
	</tr>
	<tr>
		<td><label for="quilometragem">Quilometragem</label></td>
		<td><input type="number" id="quilometragem" name="quilometragem" size="4" required
			value="${bicicleta.quilometragem}" /></td>
	</tr>
	<tr>
		<td><label for="descricao">Descrição</label></td>
		<td><input type="text" id="descricao" name="descricao" size="45"
			required value="${bicicleta.descricao}" /></td>
	</tr>
	<tr>
		<td><label for="valor">Valor</label></td>
		<td><input type="number" id="valor" name="valor" required
			min="0.01" step="any"  value="${bicicleta.valor}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
	</tr>
</table>