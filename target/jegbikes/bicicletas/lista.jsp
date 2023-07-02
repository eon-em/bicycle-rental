<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>JEG BICICLETAS</title>
<link href="${pageContext.request.contextPath}/estilo.css" rel="stylesheet" type="text/css"/>
</head>
<script>
	function filterFunction() {
	  // Declare variables
	  var input, filter, table, tr, td, i, txtValue;
	  input = document.getElementById("modelFilter");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("tabelaBicicletas");
	  tr = table.getElementsByTagName("tr");
	
	  // Loop through all table rows, and hide those who don't match the search query
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
				<h2>Gerenciamento de Bicicletas</h2>
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
						<c:choose>
							<c:when test="${Usuario != null}">
								<th>Ações</th>
							</c:when>
						</c:choose>
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
							<td>${bicicleta.valor}</td>
							<td>
								<c:if test="${Usuario != null }">
									<c:if test="${Usuario.papel == 'CLIENTE'}">
										<a href="/<%=contextPath%>/propostas/cadastro?id=${bicicleta.id}">Fazer Proposta</a>
									</c:if>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>

	</div>
	
	
</body>
</html>