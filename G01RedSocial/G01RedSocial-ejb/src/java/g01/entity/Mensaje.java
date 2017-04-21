/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g01.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "mensaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensaje.findAll", query = "SELECT m FROM Mensaje m"),
    @NamedQuery(name = "Mensaje.findByIdMensaje", query = "SELECT m FROM Mensaje m WHERE m.idMensaje = :idMensaje")})
public class Mensaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMensaje")
    private Integer idMensaje;
    @JoinColumn(name = "Notificaciones_msj_fk", referencedColumnName = "usuario_receptor")
    @OneToOne(optional = false)
    private Notificaciones notificacionesmsjfk;
    @JoinColumn(name = "Envia_mensaje_fk", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario enviamensajefk;
    @JoinColumn(name = "Recibe_mensaje_fk", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario recibemensajefk;

    public Mensaje() {
    }

    public Mensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public Integer getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public Notificaciones getNotificacionesmsjfk() {
        return notificacionesmsjfk;
    }

    public void setNotificacionesmsjfk(Notificaciones notificacionesmsjfk) {
        this.notificacionesmsjfk = notificacionesmsjfk;
    }

    public Usuario getEnviamensajefk() {
        return enviamensajefk;
    }

    public void setEnviamensajefk(Usuario enviamensajefk) {
        this.enviamensajefk = enviamensajefk;
    }

    public Usuario getRecibemensajefk() {
        return recibemensajefk;
    }

    public void setRecibemensajefk(Usuario recibemensajefk) {
        this.recibemensajefk = recibemensajefk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMensaje != null ? idMensaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensaje)) {
            return false;
        }
        Mensaje other = (Mensaje) object;
        if ((this.idMensaje == null && other.idMensaje != null) || (this.idMensaje != null && !this.idMensaje.equals(other.idMensaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "g01.entity.Mensaje[ idMensaje=" + idMensaje + " ]";
    }
    
}
