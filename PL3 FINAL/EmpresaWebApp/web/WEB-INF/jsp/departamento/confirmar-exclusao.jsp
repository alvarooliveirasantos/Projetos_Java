<%-- 
    Document   : confirmar-exclusao
    Created on : 07/04/2014, 11:07:31
    Author     : 1146322
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Confirmar Exclusão?</h3>

        <a href="${pageContext.request.contextPath}">principal</a> |
        <br/><br/>

        <form method="POST" action="${pageContext.request.contextPath}/principal?command=Departamento.confirmar-exclusao">
            <label for="codigo">C&oacute;digo:</label>
            <input type="text" size="6" readonly="true" name="codigo" value="${departamento.codigo}"/>
            <br/>
            <br/>
            <label for="nome">Nome:</label>
            <input type="text" size="40" readonly="true" name="nome" value="${departamento.nome}"/>
            <br/><br/>
            <input type="submit" value="Remover"/>
            <input type=button onClick="location.href = '${pageContext.request.contextPath}/principal?command=Departamento.listar'" value='Cancelar'/>
        </form>
    </body>
</html>
