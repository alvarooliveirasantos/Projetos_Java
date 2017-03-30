
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Departamentos</title>
    </head>
    <body>
        <h2>Departamentos</h2>
        <a href="${pageContext.request.contextPath}/principal?command=Departamento.inserir">inserir</a> | 
        <a href="${pageContext.request.contextPath}/principal?command=Departamento.alterar">alterar</a> | 
        <a href="${pageContext.request.contextPath}/principal?command=Departamento.remover">remover</a> | 
        <a href="${pageContext.request.contextPath}">principal</a> | 

        <br><br>

        <c:forEach var="departamento" items="${departamentos}">
            <c:out value="${departamento.codigo}"/>
            <c:out value="${departamento.nome}"/> 
            <br/>
        </c:forEach>

    </body>
</html>
