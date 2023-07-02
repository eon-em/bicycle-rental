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
		<h1>Lista de propostas</h1>
		<h2>
			<a href="/<%=contextPath%>/usuario">Menu Usuário</a>
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption>Lista de Propostas</caption>
			<tr>
				<th>ID</th>
				<th>Modelo</th>
				<th>Locadora</th>
				<th>Condição de Pagamento</th>
				<th>Status</th>
				<th>Data de Proposta</th>
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