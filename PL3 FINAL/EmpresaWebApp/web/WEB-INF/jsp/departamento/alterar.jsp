<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Departamento:alterar</h1>
        <a href="${pageContext.request.contextPath}">principal</a> | 
        <br/><br/>

        <form method="POST" action="${pageContext.request.contextPath}/principal?command=Departamento.alterarPorId">
            <select name="departamentos" onchange="this.form.submit()">
                <option id="" value="">--selecione--</option>
                <c:forEach var="departamento" items="${departamentos}">
                    <option value="${departamento.codigo}">
                        <c:out value="${departamento.nome}"/>
                    </option>
                </c:forEach>
            </select>
        </form>
    </body>
</html>