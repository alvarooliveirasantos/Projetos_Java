<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>App-Empresa</title>
    </head>
    <body>
        <header>
            <h3>Confirmar exclus&atilde;o?</h3>
        </header>
        <a href="${pageContext.request.contextPath}">principal</a> |
        <br/><br/>

        <form method="POST" action="${pageContext.request.contextPath}/principal?command=Funcionario.confirmar-exclusao">
            <label for="codigo">C&oacute;digo: </label>
            <input type="text" size="6" readonly="true" name="codigo" value="${funcionario.codigo}"/>
            <br/><br/>
            <label for="nome">Nome:</label>
            <input type="text" size="40" readonly="true" name="nome" value="${funcionario.nome}"/>
            <br/><br/>
            <label for="nome">Contrata&ccedil;&atilde;o :</label>
            <input type="date" name="contratacao" readonly="true" value="${funcionario.contratacao}"/>
            <br/><br/>
            <label for="cargos">Cargo:</label>
            <input type="text" name="cargo" readonly="true" value="${funcionario.cargo.nome}"/>
            <br/><br/>
            <label for="departamentos">Departamento:</label>
            <input type="text" name="departamento" readonly="true" value="${funcionario.departamento.nome}"/>
            <br/><br/>
            <input type="submit" value="Remover"/>
            <input type=button onClick="location.href = '${pageContext.request.contextPath}/principal?command=Funcionario.listar'" value='Cancelar'/>
        </form>
    </body>
</html>
