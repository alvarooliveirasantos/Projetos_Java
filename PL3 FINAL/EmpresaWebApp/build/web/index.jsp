<%-- 
    Document   : index
    Created on : 01/10/2015, 09:17:17
    Author     : Israel
--%>

<%@page import="br.edu.impacta.ads.lp3.empresa.dao.jdbc.CargoDAO"%>
<%@page import="br.edu.impacta.ads.lp3.empresa.model.Cargo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Gabes Corporation</h3>

        <a href="${pageContext.request.contextPath}/principal?command=Cargo.listar">cargo</a> | 
        <a href="${pageContext.request.contextPath}/principal?command=Departamento.listar">departamento</a> | 
        <a href="${pageContext.request.contextPath}/principal?command=Funcionario.listar">funcionário</a> | 
        
        <br/><br/>

    </body>
</html>
