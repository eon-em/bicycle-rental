<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="bundleName" value="${empty param.locale || param.locale eq 'pt' ? 'message_pt' : 'message_en'}" />
<fmt:setBundle basename="${bundleName}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="home.title" /></title>
        <link href="${pageContext.request.contextPath}/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <div id="borda">
            <h1 id="titulo"><fmt:message key="home.title" /></h1>
            <%
			String contextPath = request.getContextPath().replace("/", "");
            %>
            <ul>
                <li><a href="?locale=en">English</a></li>
                <li><a href="?locale=pt">Português</a></li>
            </ul>
            <h2><a href="/<%=contextPath%>"><fmt:message key="home.menu" /></a></h2> <br/>
            <h2><fmt:message key="home.auto" /></h2>
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