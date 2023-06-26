<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>JEG BIKES</title>
<link href="${pageContext.request.contextPath}/estilo.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	
	<div id="borda"> 
		<h1 id="titulo">JEG BIKES</h1>
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
	</div>

	
</body>
</html>