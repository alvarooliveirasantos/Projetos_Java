<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Funcionario:alterar</h1>
        <a href="${pageContext.request.contextPath}">principal</a> | 
        <br/><br/>

        <form method="POST" action="${pageContext.request.contextPath}/principal?command=Funcionario.removerPorId">
            <select name="funcionarios" onchange="this.form.submit()">
                <option id="" value="">--selecione--</option>
                <c:forEach var="funcionario" items="${funcionarios}">
                    <option value="${funcionario.codigo}">
                        <c:out value="${funcionario.nome}"/>
                    </option>
                </c:forEach>
            </select>
            <br/><br/>
            <input type=button 
                   onClick="location.href = '${pageContext.request.contextPath}/principal?command=Funcionario.listar'"
                   value='Cancelar'/>
        </form>
    </body>
</html>