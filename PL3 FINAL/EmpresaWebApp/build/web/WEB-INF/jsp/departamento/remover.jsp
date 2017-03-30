<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Departamentos</title>
    </head>
    <body>
        <h3>Departamento:remover</h3>
        <a href="${pageContext.request.contextPath}/index.jsp">principal</a> |
        <br>

        <form method="POST" action="${pageContext.request.contextPath}/principal?command=Departamento.removerPorId" >

            <label for="departamentos">Departamentos: </label>
            <select name="departamentos" onchange="this.form.submit()">
                <option id="" value="">--selecione--</option>
                <c:forEach var="departamento" items="${departamentos}">
                    <option value="${departamento.codigo}">
                        <c:out value="${departamento.nome}"/></option>
                    </c:forEach>
            </select>
            <br/><br/>
            <input type=button onClick="location.href = '${pageContext.request.contextPath}/principal?command=Departamento.listar'" value='Cancelar'/>
        </form>
    </body>
</html>
