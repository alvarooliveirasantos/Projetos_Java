<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>App-Empresa</title>
    </head>
    <body onload="document.getElementById('cargos').selectedIndex = ${funcionario.cargo.codigo};
            document.getElementById('departamentos').selectedIndex = ${funcionario.departamento.codigo}">
        <header>
            <h3>Confirmar alteração?</h3>
        </header>
        <a href="${pageContext.request.contextPath}">principal</a> |
        <br/><br/>

        <form method="POST" action="${pageContext.request.contextPath}/principal?command=Funcionario.confirmar-alteracao">
            <label for="codigo">C&oacute;digo: </label>
            <input type="text" size="6" readonly="true" name="codigo" value="${funcionario.codigo}"/>
            <br/><br/>
            <label for="nome">Nome:</label>
            <input type="text" size="40" name="nome" value="${funcionario.nome}"/>
            <br/><br/>

            <label for="nome">Contrata&ccedil;&atilde;o :</label>
            <input type="date" name="contratacao" value="${funcionario.contratacao}"/>
            <br/><br/>
            <label for="cargos">Cargo:</label>
            <select id="cargos" name="cargos">
                <option id="" value="">--selecione--</option>
                <c:forEach var="cargo" items="${cargos}">
                    <option value="${cargo.codigo}">
                        <c:out value="${cargo.nome}"/></option>
                    </c:forEach>
            </select>
            <br/><br/>
            <label for="departamentos">Departamento:</label>
            <select id="departamentos" name="departamentos">
                <option id="" value="">--selecione--</option>
                <c:forEach var="departamento" items="${departamentos}">
                    <option value="${departamento.codigo}">
                        <c:out value="${departamento.nome}"/></option>
                    </c:forEach>
            </select>
            <br/><br/>
            <input type="submit" value="Alterar"/>
            <input type=button onClick="location.href = '${pageContext.request.contextPath}/principal?command=Funcionario.listar'" value='Cancelar'/>
        </form>
    </body>
</html>
