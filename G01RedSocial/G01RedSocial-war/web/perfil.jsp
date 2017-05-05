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
       id = (Integer) request.getAttribute("idAlberto"); //El ID lo coges bien
    
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>PERFIL DE USUARIO</title>
    </head>
    <body>
            <h2>Perfil de <%= nombre %></h2>
            ---------<br/>
            -o---o--<br/>
            ---*----<br/>
            -www--<br/>
            ---------<br/>
            <br/>
        
            <h3>Datos personales</h3>
                <b>Nombre: </b><%= nombre %> <%= apellidos %><br/>
                <b>Fecha de nacimiento: </b> <%= fechanacimiento %><br/>
                <b>Ciudad de origen: </b> <%= ciudad %><br/>
                <b>Correo: </b><%= correo %><br/>
                <b>Página web: </b> <%= web %><br/>
                <b>Teléfono: </b><%= telefono %><br/>
                <b>Instagram: </b><%= instagram %><br/>
                <b>Twitter: </b><%= twitter %><br/>
                <b>Aficiones: </b><%= aficiones %><br/>
            <br/>
            
            <h3>Estudios</h3>
                <%for(Estudios est: estudios){ %>
                    <b>Nombre</b><%= est.getNombre() %><br>
                    <b>Fecha de inicio</b>
                    <%java.util.Date fechaInicioEst=est.getFechaInicio();%>
                    <%=fechaInicioEst%><br>
                    <br>
                    <b>Fecha de finalización</b>
                    <%java.util.Date fechaFinEst=est.getFechaFin();%>
                    <%=fechaFinEst%>
                    <br>
                    <b>Ubicación</b><%= est.getUbicacion()%><br>
                    <b>Descripción</b><%= est.getDescripcion() %><br>
                    <br>
                <%}%>
            <br>
 
        <br/>
        <input type="button" value="Modificar Perfil" onClick="location.href = '/G01RedSocial-war/modificar.jsp'">
    </body>
</html>
