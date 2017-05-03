<%-- 
    Document   : modificar
    Created on : 24-abr-2017, 15:03:28
    Author     : Alvaro Medina Martinez
--%>

<%@page import="g01.entity.Usuario"%>
<%
    Usuario usuario = (Usuario) request.getAttribute("usuario");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar perfil</title>
    </head>
    <body>
        Modificar perfil de: <br/><br/>
        <form method="post" action="Perfilservlet" name="modificar">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Nombre:</td>
                        <td><input type="text" name="nombre" value="<%= usuario.getNombre() %>"></td>
                    </tr>
                    <tr>
                        <td>Apellidos:</td>
                        <td><input type="text" name="apellidos" value="<%= usuario.getApellidos() %>"></td>
                    </tr>
                    <tr>
                        <td>Instagram:</td>
                        <td><input type="text" name="instagram" value="<%= usuario.getInstagram()%>"></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input type="text" name="email" value="<%= usuario.getCorreoElectronico()%>"></td>
                    </tr>
                    <tr>
                        <td>Twitter:</td>
                        <td><input type="text" name="twitter" value="<%= usuario.getTwitter()%>"></td>
                    </tr>
                    <tr>
                        <td>Telefono:</td>
                        <td><input type="text" name="telefono" value="<%= usuario.getTelefono()%>"></td>
                    </tr>
                    <tr>
                        <td>Fecha de nacimiento:</td>
                        <td><input type="text" name="fecha_nacimiento" value="<%= usuario.getFechaNacimiento()%>"></td>
                    </tr>
                    <tr>
                        <td>Pagina web:</td>
                        <td><input type="text" name="pagina_web" value="<%= usuario.getPaginaWeb()%>"></td>
                    </tr>
                    <tr>
                        <td>Aficiones:</td>
                        <td><input type="text" name="aficiones" value="<%= usuario.getAficciones()%>"></td>
                    </tr>
                    <!--
                    <tr>
                        <td>Foto:</td>
                                
                        public String openFileToString(byte[] _bytes)
                        {
                        String file_string = "";

                        for(int i = 0; i < _bytes.length; i++)
                        {
                            file_string += (char)_bytes[i];
                        }

                        return file_string;    
                        }  
                        
                        <td><input type="text" name="foto" value="<%= usuario.getFoto()%>"></td>
                    </tr>
                    -->
                    <tr>
                        <td>Ciudad:</td>
                        <td><input type="text" name="ciudad" value="<%= usuario.getCiudad()%>"></td>
                    </tr>
                    <!--
                    <tr>
                        <td>Experiencia laboral:</td>
                        <td><input type="text" name="experienciaLaboral" value="<%= usuario.getExperienciaLaboralCollection()%>"></td>
                    </tr>
                    <tr>
                        <td>Estudios:</td>
                        <td><input type="text" name="estudios" value=""></td>
                    </tr>
                    -->
                </tbody>
            </table>
            <button>Guardar</button>
        </form>
    </body>
</html>