<%-- 
    Document   : newjsp
    Created on : 21-abr-2017, 9:58:21
    Author     : Alberto
--%>
<%@page import ="g01.entity.Usuario"%>
<%@page import ="g01.facade.UsuarioFacade"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>PERFIL DE USUARIO</title>
    </head>
    <body>
        <form method="post" action="Perfilservlet">
        <h1>Perfil de: </h1>
        <%// Usuario user; %>
        <%//= user.getNombre() %>
        
        
        
        <h1>Datos personales</h1>
        <h1>Estudios</h1>
        <h1>Experiencia Laboral</h1>
        </form>
    </body>
</html>
