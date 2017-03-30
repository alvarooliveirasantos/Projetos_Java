<%-- 
    Document   : alterar
    Created on : 01/10/2015, 11:14:07
    Author     : Israel
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>.:Cargo</title>
    </head>
    <body>
        <h3>Cargo: alterar</h3>

        <form method="POST" action="${pageContext.request.contextPath}/principal">
            <input type="hidden" name="command" value="Cargo.alterarPorId"/>
            <label for="nome">Nome: </label>
            <select name="cargos" onchange="this.form.submit()">
                <option>--selecione--</option>
                <c:forEach var="cargo" items="${cargos}">
                    <option value="${cargo.codigo}">
                        <c:out value="${cargo.nome}"/>
                    </option>
                </c:forEach>
            </select>
            <br/><br/>
            <input type="button" value="Cancelar" onclick="location.href = '${pageContext.request.contextPath}/principal?command=Cargo.listar'"/>
        </form>
    </body>
</html>