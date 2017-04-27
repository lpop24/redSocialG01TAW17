/* 
    Document   : servlet
    Created on : 21-abr-2017, 9:58:21
    Author     : Alberto Cazorla Suarez
*/ 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import g01.entity.Estudios;
import g01.entity.ExperienciaLaboral;
import g01.entity.Usuario;
import g01.facade.UsuarioFacade;
import java.io.IOException;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RetailAdmin
 */
@WebServlet(name = "Perfilservlet", urlPatterns = {"/Perfilservlet"})
public class Perfilservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    private UsuarioFacade userfacade;
            
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Usuario user = this.userfacade.find(this);
        
        Integer id = user.getIdUsuario();
        request.setAttribute("id", id);
        
        String name = user.getNombre() ;
        request.setAttribute("nombre", name);
       
        String apellidos = user.getApellidos();
        request.setAttribute("apellidos", apellidos);
       
        String correo = user.getCorreoElectronico();
        request.setAttribute("correo", correo);
        
        String instagram = user.getInstagram();
        request.setAttribute("instagram", instagram);
       
        String telefono = user.getTelefono();
        request.setAttribute("telefono", telefono);
        
        String ciudad = user.getCiudad();
        request.setAttribute("ciudad", ciudad);
       
        String fechanacimiento= user.getFechaNacimiento();
        request.setAttribute("fechanacimiento", fechanacimiento);
        
        String web = user.getPaginaWeb();
        request.setAttribute("web", web);
        
        String aficiones = user.getAficciones();
        request.setAttribute("aficiones", aficiones);
        
        String twitter = user.getTwitter();
        request.setAttribute("twitter", twitter);
        
        byte[] foto = user.getFoto();
        request.setAttribute("foto", foto);
        
        Collection<ExperienciaLaboral> experiencia = user.getExperienciaLaboralCollection();
        request.setAttribute ("experiencia", experiencia);
        
        Collection<Estudios> estudios = user.getEstudiosCollection();
        request.setAttribute ("estudios", estudios);
        
        
        RequestDispatcher rd;
        
        rd = this.getServletContext().getRequestDispatcher("/perfil.jsp");
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
