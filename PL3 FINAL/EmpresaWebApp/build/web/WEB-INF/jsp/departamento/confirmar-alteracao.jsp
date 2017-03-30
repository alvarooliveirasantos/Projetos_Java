<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>App-Empresa</title>
    </head>
    <body onload="document.getElementById('departamentos').selectedIndex = ${funcionario.departamento.codigo}">
        <header>
            <h2>Confirmar alteração?</h2>
        </header>
        <a href="${pageContext.request.contextPath}/index.jsp">principal</a> |
        <br>

        <form method="POST" action="principal?command=Departamento.confirmar-alteracao">
            <label for="codigo">C&oacute;digo: </label>
            <input type="text" size="6" readonly="true" name="codigo" value="${departamento.codigo}"/>
            <br/>
            <label for="nome">Nome: </label>
            <input type="text" size="40" name="nome" value="${departamento.nome}"/>
            <br/>
            <br/>
            <input type="submit" value="Alterar"/>
            <input type=button onClick="location.href = '${pageContext.request.contextPath}/principal?command=Departamento.listar'" value='Cancelar'/>
        </form>
    </body>
</html>
