
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcionarios</title>
    </head>
    <body>
        <h2>Funcionarios</h2>
        <a href="${pageContext.request.contextPath}/principal?command=Funcionario.inserir">inserir</a> | 
        <a href="${pageContext.request.contextPath}/principal?command=Funcionario.alterar">alterar</a> | 
        <a href="${pageContext.request.contextPath}/principal?command=Funcionario.remover">remover</a> | 
        <a href="${pageContext.request.contextPath}">principal</a> | 

        <br><br>

        <c:forEach var="funcionario" items="${funcionarios}">
            <c:out value="${funcionario.codigo}"/>
            <c:out value="${funcionario.nome}"/> 
            <br/>
        </c:forEach>

    </body>
</html>
