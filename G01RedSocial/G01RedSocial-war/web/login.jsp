<%-- 
    Document   : login
    Created on : 26-abr-2017, 17:10:55
    Author     : DaniUni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="LoginServlet">
            <table>
            <tr>
                <td>Nombre de Usuario <input type="text" name="nombreUsuario"/>
            </tr>
            <tr>
                <td>Contraseña <input type="password" name="passUsuario"/>
            </tr>
            </table>
            <button>Entrar</button>
        </form>
        </br>
        </br>
            <a href="DarlAltaServlet">Crear Cuenta</a>
    </body>
</html>
