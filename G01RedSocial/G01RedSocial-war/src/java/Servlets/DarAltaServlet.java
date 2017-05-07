/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import g01.entity.Estudios;
import g01.entity.ExperienciaLaboral;
import g01.entity.Login;
import g01.entity.Usuario;
import g01.facade.EstudiosFacade;
import g01.facade.ExperienciaLaboralFacade;
import g01.facade.LoginFacade;
import g01.facade.UsuarioFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author Loubna Channouf Cherradi
 */
@WebServlet(name = "DarAltaServlet", urlPatterns = {"/DarAltaServlet"})
public class DarAltaServlet extends HttpServlet {

    @EJB
    private EstudiosFacade estudiosFacade;

    @EJB
    private ExperienciaLaboralFacade experienciaLaboralFacade;

    @EJB
    private UsuarioFacade usuarioFacade;
    
    @EJB
    private LoginFacade loginFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
       
        /**
         * LOGIN
         */
        

        String user = request.getParameter("user");
        String password = request.getParameter("password");
        
        Login log = new Login();
        
        log.setUsuario1(user);
        log.setContraseña(password);
        
        this.loginFacade.create(log);
        

        /**
         * USUARIO
         */
        Usuario usuario;
        
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String cuentaInstagram = request.getParameter("instagram");
        String email = request.getParameter("correo_electronico");
        String cuentaTwitter = request.getParameter("twitter");
        String telefono = request.getParameter("telefono");
        String fechaNacimiento = request.getParameter("fecha_nacimiento"); //Se nos ha pasado ponerlo coo date en la base de datos
        String paginaWebUsuario = request.getParameter("pagina_web");
        String aficiones = request.getParameter("aficiones");
        //byte[] foto =request.getParameter("foto");
        String temp = request.getParameter("idUsuario"); 
        String ciudad = request.getParameter("ciudad");
        //int idUsuario = Integer.valueOf(request.getParameter("idUsuario"));
        //-------------------------------------------------------------//    
        //java.util.Date fechaInicioEst = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_inicio_est"));
        //java.util.Date fechaFinEst = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_fin_est"));
        String nombreCentro = request.getParameter("nombre");
        String descripcionEst = request.getParameter("descripcion");
        String ubicacionCentro = request.getParameter("ubicacion");
        //--------------------------------------------------------------//        
        //java.util.Date fechaInicioLab = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_inicio_lab"));
        //java.util.Date fechaFinLab = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_fin_lab"));
        String empresa = request.getParameter("empresa");
        String ubicacionEmpresa = request.getParameter("ubicacion");
        String descripcionLab = request.getParameter("descripcion");
        String puesto = request.getParameter("puesto");
        String paginaWebEmpresa = request.getParameter("web");
        
       
        
        usuario = new Usuario();

        usuario.setAficciones(aficiones);
        usuario.setApellidos(apellidos);
        usuario.setCiudad(ciudad);
        usuario.setCorreoElectronico(email);
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setInstagram(cuentaInstagram);
        usuario.setNombre(nombre);
        usuario.setPaginaWeb(paginaWebEmpresa);
        usuario.setTelefono(telefono);
        usuario.setTwitter(cuentaTwitter);
        
        
        usuario.setLoginusuario(log);
        int id = (int) ( Math.random() * 1000000) + 1 ;
        usuario.setIdUsuario(id);
        
         this.usuarioFacade.create(usuario);
        
        /**
         * ESTUDIOS
         */
        //estudios = this.estudiosFacade.findAll();
        //expLaboral = this.experienciaLaboralFacade.findAll();
        
//        Collection<Estudios> estudios;     
//        Estudios est = new Estudios();
//        est.setNombre(nombreCentro);
//        est.setUbicacion(ubicacionCentro);
//        //est.setFechaInicio(fechaInicioEst);
//        //est.setFechaFin(fechaFinEst);
//        est.setDescripcion(descripcionEst);
//        
//        this.estudiosFacade.create(est);        
//        usuario.getEstudiosCollection().add(est);
        
        /**
         * EXPERIENCIA LABORAL
         */
//        Collection<ExperienciaLaboral> expLaboral;
//        ExperienciaLaboral lab = new ExperienciaLaboral();
//        
//        
//            lab.setEmpresa(empresa);
//            //lab.setFechaInicio(fechaInicioLab);
//            //lab.setFechaFin(fechaFinLab);
//            lab.setPuesto(puesto);
//            lab.setWeb(paginaWebEmpresa);
//            lab.setDescripcion(descripcionLab);
//            lab.setUbicacion(ubicacionEmpresa);
//            
//        this.experienciaLaboralFacade.create(lab);
//        usuario.getExperienciaLaboralCollection().add(lab);
        
        
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/usuarioCreado.jsp");
        rd.forward(request, response);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Prueba</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Prueba at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(DarAltaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(DarAltaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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



