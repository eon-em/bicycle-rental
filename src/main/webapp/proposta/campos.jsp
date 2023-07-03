
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="message_pt" />

<table border="1">
	<caption>
		<c:choose>
			<c:when test="${proposta.id != null}">
							<fmt:message key="offer.edit" />:
                        </c:when>
			<c:otherwise>
							<fmt:message key="offer.reg" />:
                        </c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${proposta.id != null}">
		<input type="hidden" name="id" value="${proposta.id}" />
	</c:if>
	<tr>
		<td><label for="valor"><fmt:message key="offer.value" /></label></td>
		<td><input type="number" min="0" step=".01" id="valor" name="valor" size="20" min="0.01" step="any"
			required value="${proposta.valor}" /></td>
	</tr>
	<tr>
		<td><label for="condPagamento">Condição de Pagamento</label></td>
		<td><input type="text" id="condPagamento" name="condPagamento" size="45" required
			value="${proposta.condPagamento}" /></td>
	</tr>
	<tr>
		<td><label for="idBicicleta">idBicicleta</label></td>
		<td><input type="number" id="idBicicleta" name="idBicicleta" size="20" readonly required
			value="${proposta.bicicleta.id}" /></td>
	</tr>
	<tr>
		<td><label for="nomeLocadora">Locadora</label></td>
		<td><input type="text" id="nomeLocadora" name="nomeLocadora" size="50" readonly required
			value="${proposta.bicicleta.locadora.nome}" /></td>
	</tr>
	<tr>
		<td><label for="idCliente">Cliente</label></td>
		<td><input type="number" id="idCliente" name="idCliente" size="20" readonly required
			value="${proposta.cliente.id_usuario}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" onclick="validarFormulario()"/></td>
		<script>

			function validarFormulario() {
				var condPagamento = document.getElementById("condPagamento").value;
				var idBicicleta = document.getElementById("idBicicleta").value;
				var nomeLocadora = document.getElementById("nomeLocadora").value;
				var idCliente = document.getElementById("idCliente").value;				
  
				if (condPagamento === "") {
				  alert("O campo de Condições de Pagamento está em branco!");
				  return false; // Impede o envio do formulário
				}
				if (idBicicleta === "") {
				  alert("O campo de IdBicicleta está em branco!");
				  return false; // Impede o envio do formulário
				}
				if (nomeLocadora === "") {
				  alert("O campo do Nome da Locadora está em branco!");
				  return false; // Impede o envio do formulário
				}
				if (idCliente === "") {
				  alert("O campo de Cliente está em branco!");
				  return false; // Impede o envio do formulário
				}
				return true; // Permite o envio do formulário
			}
		</script>
	</tr>
</table>
