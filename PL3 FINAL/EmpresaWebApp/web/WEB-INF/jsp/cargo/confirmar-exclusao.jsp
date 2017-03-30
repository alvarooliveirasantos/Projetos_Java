<%-- 
    Document   : inserir
    Created on : 01/10/2015, 11:13:44
    Author     : Israel
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>.:Cargo</title>
    </head>
    <body>
        <h3>Cargo: Confirmar exclusão?</h3>

        <form method="POST" action="${pageContext.request.contextPath}/principal">
            <input type="hidden" name="command" value="Cargo.confirmar-exclusao"/>
            <label for="codigo">C&oacute;digo:&nbsp;</label>
            <input type="text" name="codigo" size="5" readonly="true" value="${cargo.codigo}"/>
            <br/><br/>
            <label for="nome">Nome: </label>
            <input type="text" name="nome" size="40" readonly="true" value="${cargo.nome}"/>
            <br/><br/>
            <input type="submit"/>
            <input type="button" value="Cancelar" onclick="location.href = '${pageContext.request.contextPath}/principal?command=Cargo.listar'"/>
        </form>
    </body>
</html>
