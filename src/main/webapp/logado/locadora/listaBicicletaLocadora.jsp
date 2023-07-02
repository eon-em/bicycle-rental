<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Gerenciamento de Bicicletas</title>
		<link href="${pageContext.request.contextPath}/estilo.css" rel="stylesheet" type="text/css"/>
	</head>
	<script>
		function filterFunction() {
		  var input, filter, table, tr, td, i, txtValue;
		  input = document.getElementById("modelFilter");
		  filter = input.value.toUpperCase();
		  table = document.getElementById("tabelaBicicletas");
		  tr = table.getElementsByTagName("tr");
		
		  for (i = 0; i < tr.length; i++) {
			td = tr[i].getElementsByTagName("td")[1];
			if (td) {
			  txtValue = td.textContent || td.innerText;
			  if (txtValue.toUpperCase().indexOf(filter) > -1) {
				tr[i].style.display = "";
			  } else {
				tr[i].style.display = "none";
			  }
			}
		  }
		}
	</script>
	<body>
		
		<div id="borda">
			<h1 id="titulo">JEG BICICLETAS</h1>
			<%
				String contextPath = request.getContextPath().replace("/", "");
			%>
			<div align="center">
				<h2>
					<a href="/<%=contextPath%>">Menu Principal</a> <br/>
					<a href="${pageContext.request.contextPath}/locadora">Menu Locadora</a>
					<a href="${pageContext.request.contextPath}/bicicleta/cadastro">Nova Bicicleta</a>
				</h2>
			</div>
	
			<div align="center">
			<input type="text" id="modelFilter" onkeyup="filterFunction()" placeholder ="Procure pelo modelo">
				<table id="tabelaBicicletas" border="1">
					<caption>Lista de Bicicletas</caption>
					<tr>
						<th>ID</th>
						<th>modelo</th>
						<th>Locadora</th>
						<th>placa</th>
						<th>Ano</th>
						<th>Quilometragem</th>
						<th>Descrição</th>
						<th>Valor</th>
					</tr>
					<c:forEach var="bicicleta" items="${requestScope.listaBicicletas}">
						<tr>
							<td>${bicicleta.id}</td>
							<td>${bicicleta.modelo}</td>
							<td>${bicicleta.locadora.nome}</td>
							<td>${bicicleta.placa}</td>
							<td>${bicicleta.ano}</td>
							<td>${bicicleta.quilometragem}</td>
							<td>${bicicleta.descricao}</td>
							<td>${cabicicletarro.valor}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		
		
	</body>
</html>