/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g01.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "notificaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notificaciones.findAll", query = "SELECT n FROM Notificaciones n"),
    @NamedQuery(name = "Notificaciones.findByUsuarioReceptor", query = "SELECT n FROM Notificaciones n WHERE n.usuarioReceptor = :usuarioReceptor")})
public class Notificaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_receptor")
    private Integer usuarioReceptor;
    @Lob
    @Column(name = "peticion_amistad")
    private byte[] peticionAmistad;
    @JoinColumn(name = "usuario_receptor", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "usuario_emisor", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuarioEmisor;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "notificacionesmsjfk")
    private Mensaje mensaje;

    public Notificaciones() {
    }

    public Notificaciones(Integer usuarioReceptor) {
        this.usuarioReceptor = usuarioReceptor;
    }

    public Integer getUsuarioReceptor() {
        return usuarioReceptor;
    }

    public void setUsuarioReceptor(Integer usuarioReceptor) {
        this.usuarioReceptor = usuarioReceptor;
    }

    public byte[] getPeticionAmistad() {
        return peticionAmistad;
    }

    public void setPeticionAmistad(byte[] peticionAmistad) {
        this.peticionAmistad = peticionAmistad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioEmisor() {
        return usuarioEmisor;
    }

    public void setUsuarioEmisor(Usuario usuarioEmisor) {
        this.usuarioEmisor = usuarioEmisor;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioReceptor != null ? usuarioReceptor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notificaciones)) {
            return false;
        }
        Notificaciones other = (Notificaciones) object;
        if ((this.usuarioReceptor == null && other.usuarioReceptor != null) || (this.usuarioReceptor != null && !this.usuarioReceptor.equals(other.usuarioReceptor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "g01.entity.Notificaciones[ usuarioReceptor=" + usuarioReceptor + " ]";
    }
    
}
