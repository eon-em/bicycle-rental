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
		</div>
		
		
	</body>

</html>