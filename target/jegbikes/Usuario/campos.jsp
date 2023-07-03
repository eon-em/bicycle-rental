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
		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
	</tr>
</table>