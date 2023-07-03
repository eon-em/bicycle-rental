<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		<c:if test="${mensagens.existeErros}">
	    <div id="erro">
	        <ul>
           		<c:forEach var="erro" items="${mensagens.erros}">
	               <li> ${erro} </li>
              	</c:forEach>
	        </ul>	
	    </div>
    </c:if>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<div align="center">
		<h1><fmt:message key="offer.list" />:</h1>
		<h2>
			<a href="/<%=contextPath%>/usuario"><fmt:message key="user.menu" />:</a>
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption><fmt:message key="offer.list" />:</caption>
			<tr>
				<th>ID</th>
				<th><fmt:message key="bike.model" />:</th>
				<th><fmt:message key="bike.rental" />:</th>
				<th><fmt:message key="bike.pay" />:</th>
				<th><fmt:message key="bike.status" />:</th>
				<th><fmt:message key="offer.date" />:</th>
			</tr>
			<c:forEach var="Proposta" items="${requestScope.listaProposta}">
				<tr>
					<td>${Proposta.id}</td>
					<td>${Proposta.bicicleta.modelo}</td>
					<td>${Proposta.bicicleta.locadora.nome}</td>
					<td>${Proposta.condPagamento}</td>
					<td>${Proposta.status}</td>
					<td>${Proposta.dataProposta}
				</tr>
			</c:forEach>
		</table>
	</div>
	</div>

	
</body>
</html>