<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Departamento:inserir!</h2>

        <a href="${pageContext.request.contextPath}">principal</a> | 
        <br/><br/>
        <form method="POST" action="${pageContext.request.contextPath}/principal?command=Departamento.confirmar-insercao">
            <label for="nome">nome: </label>
            <input type="text" name="nome" value="${departamento.nome}" required="true" size="30"/>
            <br/><br/>
            <input type="submit"/>
            <input type=button 
                   onClick="location.href = '${pageContext.request.contextPath}/principal?command=Departamento.listar'"
                   value='Cancelar'/>
        </form>
    </body>
</html>
