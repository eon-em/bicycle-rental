<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
	</tr>
</table>
