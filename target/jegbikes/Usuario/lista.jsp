<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>RC VEICULOS</title>
		<link href="${pageContext.request.contextPath}/estilo.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		
		<div id="borda">
			<h1 id="titulo">RC VEICULOS</h1>
			<%
				String contextPath = request.getContextPath().replace("/", "");
			%>
			<h2><a href="/<%=contextPath%>">Menu Principal</a></h2>
			<div align="center">
				<h2>Gerenciamento de Usuários</h2>
				<h2>
					<a href="/<%= contextPath%>/admin/cadastroCliente">Cadastro Cliente</a> <br/>
					<a href="/<%= contextPath%>/admin/cadastroLocadora">Cadastro Locadora</a>
				</h2>
			</div>

			<div align="center">
				<table border="1">
					<caption>Lista de Usuários</caption>
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
							<td><a href="/<%= contextPath%>/admin/edicao?id=${usuario.id}">Edição</a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="/<%= contextPath%>/admin/remocao?id=${usuario.id}"
								onclick="return confirm('Tem certeza de que deseja excluir este item?');">
									Remoção </a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>


		
	</body>
</html>