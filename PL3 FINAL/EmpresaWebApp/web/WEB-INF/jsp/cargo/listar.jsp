<%-- 
    Document   : listar
    Created on : 01/10/2015, 11:14:17
    Author     : Israel
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Cargos:listar.</h3>
        
        <a href="${pageContext.request.contextPath}/principal?command=Cargo.formulario">inserir</a>&nbsp;|&nbsp;
        <a href="${pageContext.request.contextPath}/principal?command=Cargo.alterar">alterar</a>&nbsp;|&nbsp;
        <a href="${pageContext.request.contextPath}/principal?command=Cargo.remover">remover</a>&nbsp;|&nbsp;
        <a href="${pageContext.request.contextPath}">principal</a>&nbsp;|&nbsp;

        <br/><br/>
        
        <c:forEach var="cargo" items="${cargos}">
            <c:out value="${cargo.codigo}"/>&nbsp;&#45;&nbsp;
            <c:out value="${cargo.nome}"/>
            <br/>
        </c:forEach>
        
    </body>
</html>
