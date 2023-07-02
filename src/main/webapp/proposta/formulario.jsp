<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

	<head>
		<title>JEG BICICLETAS</title>
		<link href="${pageContext.request.contextPath}/estilo.css" rel="stylesheet" type="text/css"/>
	</head>
	
	<body>
		
		<div id="borda">
			<h1 id="titulo">JEG BICICLETAS</h1>
        <%
			String contextPath = request.getContextPath().replace("/", "");
        %>
        <h2><a href="/<%=contextPath%>">Menu Principal</a> <br/> </h2>
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
				<h1>Gerenciamento de propostas</h1>
				<h2>
					<a href="lista">Lista de propostas</a>
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