<%-- 
    Document   : darDeAlta
    Created on : 27-abr-2017, 16:16:45
    Author     : Loubna Channouf Cherradi
--%>


<%@page import="g01.entity.Login" %>
<%
    Login login = new Login();
%>
<%@page import="g01.entity.Usuario"%>
<%
    Usuario usuario = new Usuario();
%>
<%@page import="g01.entity.Estudios"%>
<%@page import="g01.entity.ExperienciaLaboral"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Usuario</title>
    </head>
    <body>
        <h1>Crear Cuenta</h1>
        <form method="post" action="DarAltaServlet">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Nombre de Usuario </td>
                        <td><input type="text" name="user" /></td>
                    </tr>
                    <tr>
                        <td>Contraseña</td>
                        <td><input type="password" name="password" /></td>
                    </tr>
                    <tr>
                        <td>Nombre:</td>
                        <td><input type="text" name="nombre" ></td>
                    </tr>
                    <tr>
                        <td>Apellidos:</td>
                        <td><input type="text" name="apellidos" ></td>
                    </tr>
                    <tr>
                        <td>Instagram:</td>
                        <td><input type="text" name="instagram" ></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input type="text" name="correo_electronico" ></td>
                    </tr>
                    <tr>
                        <td>Twitter:</td>
                        <td><input type="text" name="twitter" ></td>
                    </tr>
                    <tr>
                        <td>Telefono:</td>
                        <td><input type="text" name="telefono" ></td>
                    </tr>
                    <tr>
                        <td>Fecha de nacimiento:</td>
                        <td><input type="text" name="fecha_nacimiento" ></td>
                    </tr>
                    <tr>
                        <td>Pagina web:</td>
                        <td><input type="text" name="pagina_web" ></td>
                    </tr>
                    <tr>
                        <td>Aficiones:</td>
                        <td><input type="text" name="aficiones" ></td>
                    </tr>
                    <tr>
                        <td>Ciudad:</td>
                        <td><input type="text" name="ciudad" ></td>
                    </tr>
                    
                </tbody>
            </table>
                    
            <button>Guardar</button>
        </form>
    </body>
    </body>
</html>
