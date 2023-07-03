<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
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
            <h2><a href="/<%=contextPath%>"><fmt:message key="home.menu" />:</a></h2> <br/>
            <h2><fmt:message key="home.aut" />:</h2>
            <c:if test="${mensagens.existeErros}">
                <div id="erro">
                    <ul>
                        <c:forEach var="erro" items="${mensagens.erros}">
                            <li> ${erro} </li>
                            </c:forEach>
                    </ul>
                </div>
            </c:if>
            <form method="post" action="doLogin.jsp">
                <table>
                    <tr>
                        <th><fmt:message key="home.user.login" />:</th>
                        <td><input type="text" name="email" value="${param.email}"/></td> 
                    </tr>
                    <tr>
                        <th><fmt:message key="home.user.pass" />:</th> <td><input type="password" name="senha" value="${param.senha}" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"> 
                            <input type="submit" name="bOK" value="Entrar"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        
        
    </body>
</html>
