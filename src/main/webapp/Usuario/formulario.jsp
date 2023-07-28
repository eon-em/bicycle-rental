<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="bundleName" value="${empty param.locale || param.locale eq 'pt' ? 'message_pt' : 'message_en'}" />
<fmt:setBundle basename="${bundleName}" />
<html>

<head>
	<title><fmt:message key="home.title" /></title>
	<link href="${pageContext.request.contextPath}/estilo.css" rel="stylesheet" type="text/css"/>
</head>

<body>
	
	<div id="borda">
		<h1 id="titulo"><fmt:message key="home.title" /></h1>
        <%
		String contextPath = request.getContextPath().replace("/", "");
        %>
		<ul>
			<li><a href="?locale=en">English</a></li>
			<li><a href="?locale=pt">Português</a></li>
		</ul>
        <h2><a href="/<%=contextPath%>"><fmt:message key="home.menu" /></a> <br/> </h2>
		<div align="center">
			<h1><fmt:message key="user.management" /></h1>
			<h2>
				<a href="lista"><fmt:message key="user.list" /></a>
			</h2>
		</div>
		<div align="center">
			<c:choose>
				<c:when test="${Usuario != null}">
					<form action="atualizacao" method="post">
						<%@include file="campos.jsp"%>
					</form>
				</c:when>
				<c:otherwise>
					<form action="insercao" method="post">
						<%@include file="campos.jsp"%>
					</form>
				</c:otherwise>
			</c:choose>
		</div>
		<c:if test="${!empty requestScope.mensagens}">
			<ul class="erro">
				<c:forEach items="${requestScope.mensagens}" var="mensagem">
					<li>${mensagem}</li>
				</c:forEach>
			</ul>
		</c:if>
	</div>
	
	
</body>

</html>