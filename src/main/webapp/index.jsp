<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="message_pt" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" type = "text/css" href = "estilo.css"/>
        <title><fmt:message key="home.title" /></title>
    </head>
    <body>
    	
        <div id="borda">
            <h1 id="titulo"><fmt:message key="home.title" /></h1>
            <%
            String contextPath = request.getContextPath().replace("/", "");
            %>
            <h2> <a href="login.jsp"><fmt:message key="home.login" /></a> <br/> </h2>
            <h2> <a href="/<%=contextPath%>/bicicleta/listaLocadoras"><fmt:message key="home.list.rental" /></a> </h2> <br/>
        </div>
        
        
    </body>
</html>