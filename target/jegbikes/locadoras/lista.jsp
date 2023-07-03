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
	  input = document.getElementById("cityFilter");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("tabelaLocadoras");
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
				<h2>Gerenciamento de Locadoras</h2>
			</div>

			<div align="center">
			<input type="text" id="modelFilter" onkeyup="filterFunction()" placeholder ="Procure por cidade">
				<table id="tabelaLocadoras" border="1">
					<caption>Lista de Locadoras</caption>
					<tr>
						<th>Nome</th>
						<th>Descrição</th>
						<th>CNPJ</th>
						<th>Cidade</th>
					</tr>
					<c:forEach var="locadora" items="${requestScope.listaLocadoras}">
						<tr>
							<td>${locadora.nome}</td>
							<td>${locadora.descricao}</td>
							<td>${locadora.cnpj}</td>
							<td>${locadora.cidade}</td>
					</c:forEach>
				</table>
			</div>

	</div>
	
	
</body>
</html>