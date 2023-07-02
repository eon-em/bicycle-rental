<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
            
            <h2><a href="${pageContext.request.contextPath}/admin/lista">Gestão de Usuários</a> </h2> <br/>
            <h2><a href="${pageContext.request.contextPath}/logout.jsp">Sair</a> <br> </h2>
        </div>
        
    </body>
</html>