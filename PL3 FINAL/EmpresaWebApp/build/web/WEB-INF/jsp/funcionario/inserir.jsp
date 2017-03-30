<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Funcionario:inserir!</h3>

        <a href="${pageContext.request.contextPath}">principal</a> | 
        <br/><br/>
        <form method="POST" action="${pageContext.request.contextPath}/principal?command=Funcionario.confirmar-insercao">
            <label for="nome">nome: </label>
            <input type="text" name="nome" required="true" size="60"/>
            <br/><br/>
            <label for="contratacao">nome: </label>
            <input name="contratacao" type="date" required="true"/>
            <br/><br/>
            <label for="departamentos">departamento: </label>
            <select name="departamentos" required="true">
                <option id="" value="">--selecione--</option>
                <c:forEach var="departamento" items="${departamentos}">
                    <option value="${departamento.codigo}">
                        <c:out value="${departamento.nome}"/></option>
                    </c:forEach>
            </select>
            <br/><br/>
            <label for="cargos">cargo: </label>
            <select name="cargos" required="true">
                <option id="" value="">--selecione--</option>
                <c:forEach var="cargo" items="${cargos}">
                    <option value="${cargo.codigo}">
                        <c:out value="${cargo.nome}"/></option>
                    </c:forEach>
            </select>
            <br>
            <br>
            <input type="submit"/>
            <input type=button 
                   onClick="location.href = '${pageContext.request.contextPath}/principal?command=Funcionario.listar'"
                   value='Cancelar'/>
        </form>
    </body>
</html>
