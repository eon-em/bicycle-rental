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

		<div align="center">
			<h2>Gerenciamento de Locações</h2>
			<h2>
				<a href="${pageContext.request.contextPath}/locadora">Menu da Locadora</a>
			</h2>
		</div>

		<div align="center">
			<table id="tabelaBicicletas" border="1">
				<caption>Lista de Locações</caption>
				<tr>
					<th>ID</th>
					<th>Cliente</th>
					<th>Locadora</th>
					<th>Data de Locação</th>
					<c:choose>
						<c:when test="${Usuario != null}">
							<th>Ações</th>
						</c:when>
					</c:choose>
				</tr>
				<c:forEach var="bicicleta" items="${requestScope.listaBicicletas}">
					<tr>
						<td>${bicicleta.id}</td>
						<td>${bicicleta.cliente.nome}</td>
						<td>${bicicleta.locadora.nome}</td>
						<td>${bicicleta.dataLocacao}</td>
							<!-- <td>
								<c:if test="${Usuario != null }">
									<c:if test="${Usuario.papel == 'CLIENTE'}">
										<a href="/<%=contextPath%>/propostas/cadastro?id=${bicicleta.id}">Fazer Proposta</a>
									</c:if>
								</c:if>
							</td> -->
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>