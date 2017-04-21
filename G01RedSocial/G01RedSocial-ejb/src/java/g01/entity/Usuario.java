/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g01.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos"),
    @NamedQuery(name = "Usuario.findByInstagram", query = "SELECT u FROM Usuario u WHERE u.instagram = :instagram"),
    @NamedQuery(name = "Usuario.findByCorreoElectronico", query = "SELECT u FROM Usuario u WHERE u.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "Usuario.findByTwitter", query = "SELECT u FROM Usuario u WHERE u.twitter = :twitter"),
    @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Usuario.findByFechaNacimiento", query = "SELECT u FROM Usuario u WHERE u.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Usuario.findByPaginaWeb", query = "SELECT u FROM Usuario u WHERE u.paginaWeb = :paginaWeb"),
    @NamedQuery(name = "Usuario.findByAficciones", query = "SELECT u FROM Usuario u WHERE u.aficciones = :aficciones"),
    @NamedQuery(name = "Usuario.findByCiudad", query = "SELECT u FROM Usuario u WHERE u.ciudad = :ciudad")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "apellidos")
    private String apellidos;
    @Size(max = 45)
    @Column(name = "instagram")
    private String instagram;
    @Size(max = 45)
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Size(max = 45)
    @Column(name = "twitter")
    private String twitter;
    @Size(max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 45)
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    @Size(max = 45)
    @Column(name = "pagina_web")
    private String paginaWeb;
    @Size(max = 45)
    @Column(name = "aficciones")
    private String aficciones;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @Size(max = 45)
    @Column(name = "ciudad")
    private String ciudad;
    @JoinTable(name = "user_friend_user", joinColumns = {
        @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario")}, inverseJoinColumns = {
        @JoinColumn(name = "Usuario_idUsuario1", referencedColumnName = "idUsuario")})
    @ManyToMany
    private Collection<Usuario> usuarioCollection;
    @ManyToMany(mappedBy = "usuarioCollection")
    private Collection<Usuario> usuarioCollection1;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Notificaciones notificaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioEmisor")
    private Collection<Notificaciones> notificacionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioidUsuario")
    private Collection<ExperienciaLaboral> experienciaLaboralCollection;
    @JoinColumn(name = "Login_usuario", referencedColumnName = "usuario")
    @OneToOne(optional = false)
    private Login loginusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enviamensajefk")
    private Collection<Mensaje> mensajeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recibemensajefk")
    private Collection<Mensaje> mensajeCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioidUsuario")
    private Collection<Estudios> estudiosCollection;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getAficciones() {
        return aficciones;
    }

    public void setAficciones(String aficciones) {
        this.aficciones = aficciones;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection1() {
        return usuarioCollection1;
    }

    public void setUsuarioCollection1(Collection<Usuario> usuarioCollection1) {
        this.usuarioCollection1 = usuarioCollection1;
    }

    public Notificaciones getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(Notificaciones notificaciones) {
        this.notificaciones = notificaciones;
    }

    @XmlTransient
    public Collection<Notificaciones> getNotificacionesCollection() {
        return notificacionesCollection;
    }

    public void setNotificacionesCollection(Collection<Notificaciones> notificacionesCollection) {
        this.notificacionesCollection = notificacionesCollection;
    }

    @XmlTransient
    public Collection<ExperienciaLaboral> getExperienciaLaboralCollection() {
        return experienciaLaboralCollection;
    }

    public void setExperienciaLaboralCollection(Collection<ExperienciaLaboral> experienciaLaboralCollection) {
        this.experienciaLaboralCollection = experienciaLaboralCollection;
    }

    public Login getLoginusuario() {
        return loginusuario;
    }

    public void setLoginusuario(Login loginusuario) {
        this.loginusuario = loginusuario;
    }

    @XmlTransient
    public Collection<Mensaje> getMensajeCollection() {
        return mensajeCollection;
    }

    public void setMensajeCollection(Collection<Mensaje> mensajeCollection) {
        this.mensajeCollection = mensajeCollection;
    }

    @XmlTransient
    public Collection<Mensaje> getMensajeCollection1() {
        return mensajeCollection1;
    }

    public void setMensajeCollection1(Collection<Mensaje> mensajeCollection1) {
        this.mensajeCollection1 = mensajeCollection1;
    }

    @XmlTransient
    public Collection<Estudios> getEstudiosCollection() {
        return estudiosCollection;
    }

    public void setEstudiosCollection(Collection<Estudios> estudiosCollection) {
        this.estudiosCollection = estudiosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "g01.entity.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
