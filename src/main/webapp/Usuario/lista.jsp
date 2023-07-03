<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><fmt:message key="home.title" />:</title>
		<link href="${pageContext.request.contextPath}/estilo.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		
		<div id="borda">
			<h1 id="titulo"><fmt:message key="home.title" />:</h1>
			<%
				String contextPath = request.getContextPath().replace("/", "");
			%>
			<h2><a href="/<%=contextPath%>"><fmt:message key="home.menu" />:</a></h2>
			<div align="center">
				<h2><fmt:message key="user.management" />:</h2>
				<h2>
					<a href="/<%= contextPath%>/admin/cadastroCliente"><fmt:message key="client.reg" />:</a> <br/>
					<a href="/<%= contextPath%>/admin/cadastroLocadora"><fmt:message key="rental.reg" />:</a>
				</h2>
			</div>

			<div align="center">
				<table border="1">
					<caption><fmt:message key="user.list" />:</caption>
					<tr>
						<th>ID</th>
						<th>email</th>
						<th>papel</th>
						<th>ações</th>
					</tr>
					<c:forEach var="usuario" items="${requestScope.listaUsuario}">
						<tr>
							<td>${usuario.id}</td>
							<td>${usuario.email}</td>
							<td>${usuario.papel}</td>
							<td><a href="/<%= contextPath%>/admin/edicao?id=${usuario.id}"><fmt:message key="user.edit" />:</a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="/<%= contextPath%>/admin/remocao?id=${usuario.id}"
								onclick="return confirm('Tem certeza de que deseja excluir este item?');">
									<fmt:message key="user.remove" />: </a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>


		
	</body>
</html>