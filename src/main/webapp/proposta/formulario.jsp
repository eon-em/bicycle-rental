<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="message_pt" />
<html>

	<head>
		<title><fmt:message key="home.title" />:</title>
		<link href="${pageContext.request.contextPath}/estilo.css" rel="stylesheet" type="text/css"/>
	</head>
	
	<body>
		
		<div id="borda">
			<h1 id="titulo"><fmt:message key="home.title" />:</h1>
        <%
			String contextPath = request.getContextPath().replace("/", "");
        %>
        <h2><a href="/<%=contextPath%>"><fmt:message key="home.menu" />:</a> <br/> </h2>
		<%
			String contextPath = request.getContextPath().replace("/", "");
		%>
			<c:if test="${mensagens.existeErros}">
				<div id="erro">
					<ul>
						<c:forEach var="erro" items="${mensagens.erros}">
							<li> ${erro} </li>
						</c:forEach>
					</ul>	
				</div>
			</c:if>
			<div align="center">
				<h1><fmt:message key="offer.management" />:</h1>
				<h2>
					<a href="lista"><fmt:message key="offer.list" />:</a>
					<a href="/<%=contextPath%>/usuario/listaBicicletas">Lista de Bicicletas</a>
				</h2>
			</div>
			<div align="center">
				<c:choose>
					<c:when test="${proposta.id != null}">
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
		</div>
		
		
	</body>

</html>