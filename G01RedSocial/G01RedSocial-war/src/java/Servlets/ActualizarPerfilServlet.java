/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Alvaro Medina Martinez

package Servlets;

import g01.entity.Usuario;
import g01.facade.UsuarioFacade;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alvaro Medina Martinez
 */
@WebServlet(name = "ActualizarPerfil", urlPatterns = {"/ActualizarPerfil"})
public class ActualizarPerfilServlet extends HttpServlet {
    
    @EJB
    private UsuarioFacade usuarioFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        HttpSession session = request.getSession();
        
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        String nombreUsuario = request.getParameter("nombre");
        String apellidosUsuario = request.getParameter("apellidos");
        String instagramUsuario = request.getParameter("instagram");
        String emailUsuario = request.getParameter("email");
        String twitterUsuario = request.getParameter("twitter");
        String telefonoUsuario = request.getParameter("telefono");
        String fecha_nacimientoUsuario = request.getParameter("fecha_nacimiento");
        String pagina_webUsuario = request.getParameter("pagina_web");
        String aficionesUsuario = request.getParameter("aficiones");
        String ciudadUsuario = request.getParameter("ciudad");
        
        Usuario usuarioEditar;
        usuarioEditar = this.usuarioFacade.find(usuario.getIdUsuario());
        
        usuarioEditar.setNombre(nombreUsuario);
        usuarioEditar.setApellidos(apellidosUsuario);
        usuarioEditar.setInstagram(instagramUsuario);
        usuarioEditar.setCorreoElectronico(emailUsuario);
        usuarioEditar.setTwitter(twitterUsuario);
        usuarioEditar.setTelefono(telefonoUsuario);
        usuarioEditar.setFechaNacimiento(fecha_nacimientoUsuario);
        usuarioEditar.setPaginaWeb(pagina_webUsuario);
        usuarioEditar.setAficciones(aficionesUsuario);
        usuarioEditar.setCiudad(ciudadUsuario);
        
        usuarioFacade.edit(usuarioEditar);
        
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/Perfilservlet");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}