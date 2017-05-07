<%-- 
    Document   : newjsp
    Created on : 21-abr-2017, 9:58:21
    Author     : Alberto Cazorla Suarez
--%>
<%@page import="java.util.List"%>
<%@page import="g01.entity.Estudios"%>
<%@page import="java.util.Collection"%>
<%@page import="g01.entity.ExperienciaLaboral"%>
<%@page import ="g01.entity.Usuario"%>
<%@page import ="g01.facade.UsuarioFacade"%>

<%
       Integer id;
       id = (Integer) request.getAttribute("idAlberto");
    
       String nombre;
       nombre = (String) request.getAttribute("nombre");
       
       String apellidos;
       apellidos = (String) request.getAttribute("apellidos");
                     
       String fechanacimiento;
       fechanacimiento = (String) request.getAttribute("fechanacimiento");
              
       String ciudad;
       ciudad = (String) request.getAttribute ("ciudad");
       
       String correo;
       correo = (String) request.getAttribute ("correo");
       
       String web;
       web = (String) request.getAttribute("web");
      
       String telefono;
       telefono = (String) request.getAttribute ("telefono");
       
       String instagram;
       instagram = (String) request.getAttribute ("instagram");
        
       String twitter;
       twitter = (String) request.getAttribute("twitter");
              
       String aficiones;
       aficiones = (String) request.getAttribute("aficiones");
        /*
        byte[] foto;
        //foto = (byte[]) request.getAttribute("foto");
        */
        
        
        List<ExperienciaLaboral> experiencia;
        experiencia = (List<ExperienciaLaboral>) request.getAttribute("experiencia");
        
        List<Estudios> estudios;
        estudios = (List<Estudios>)request.getAttribute ("estudios");
        
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<style>
    table {
        width: 25%;
    }
    td {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }
    th {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
        background-color: #dddddd;
    }
</style>
</head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>PERFIL DE USUARIO</title>
    </head>
    <body>
            <h2>Perfil de <%= nombre %></h2>
            
             <table>
                <th>Datos personales</th>
                <tr>
                <td><b>Nombre: </b></td><td><%= nombre %> <%= apellidos %><br/></td>
                </tr>
                <tr>
                <td><b>Fecha de nacimiento: </b> </td><td><%= fechanacimiento %><br/></td>
                </tr>
                <tr>
                <td><b>Ciudad de origen: </b></td><td> <%= ciudad %><br/></td>
                </tr>
                <tr>
                <td><b>Correo: </b></td><td><%= correo %><br/></td>
                </tr>
                <tr>
                <td><b>Página web: </b></td><td> <%= web %><br/></td>
                </tr>
                <tr>
                <td><b>Teléfono: </b></td><td><%= telefono %><br/></td>
                </tr>
                <tr>
                <td><b>Instagram: </b></td><td><%= instagram %><br/></td>
                </tr>
                <tr>
                <td><b>Twitter: </b></td><td><%= twitter %><br/></td>
                </tr>
                <tr>
                <td><b>Aficiones: </b></td><td><%= aficiones %><br/></td>
                </tr>
                <br/>
                <br/>
            </table>
            <br/>
            <br/>
            
            <table>
                <th>Estudios</th>
                    <%for(Estudios est: estudios){ %>
                    <tr>
                    <td><b>Nombre: </b></td><td><%= est.getNombre() %><br/></td>
                    </tr>
                    <tr>
                    <td><b>Fecha de inicio: </b></td><td>
                    <%java.util.Date fechaInicioEst=est.getFechaInicio();%>
                    <%=fechaInicioEst%><br/></td>
                    </tr>
                    <tr>
                    <td><b>Fecha de finalización: </b></td><td>
                    <%java.util.Date fechaFinEst=est.getFechaFin();%>
                    <%=fechaFinEst%><br/></td>
                    </tr>
                    <tr>
                    <td><b>Ubicación: </b></td><td><%= est.getUbicacion()%><br/></td>
                    </tr>
                    <tr>
                    <td><b>Descripción: </b></td><td><%= est.getDescripcion() %><br/></td>
                    </tr>
                    <tr>
                    <td> <br/></td>
                    </tr>
                    <br/>
                    <%}%>
              </table>
          
            
        <br/>

        <input type="button" value="Modificar Perfil" onClick="location.href = 'modificar.jsp'">
        <input type="button" value="Cerrar Sesión" onClick="location.href = 'login.jsp'">

    </body>
</html>
