/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g01.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "estudios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudios.findAll", query = "SELECT e FROM Estudios e"),
    @NamedQuery(name = "Estudios.findByIdEstudios", query = "SELECT e FROM Estudios e WHERE e.idEstudios = :idEstudios"),
    @NamedQuery(name = "Estudios.findByFechaInicio", query = "SELECT e FROM Estudios e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Estudios.findByFechaFin", query = "SELECT e FROM Estudios e WHERE e.fechaFin = :fechaFin"),
    @NamedQuery(name = "Estudios.findByNombre", query = "SELECT e FROM Estudios e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Estudios.findByDescripcion", query = "SELECT e FROM Estudios e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Estudios.findByUbicacion", query = "SELECT e FROM Estudios e WHERE e.ubicacion = :ubicacion")})
public class Estudios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEstudios")
    private Integer idEstudios;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "ubicacion")
    private String ubicacion;
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuarioidUsuario;

    public Estudios() {
    }

    public Estudios(Integer idEstudios) {
        this.idEstudios = idEstudios;
    }

    public Integer getIdEstudios() {
        return idEstudios;
    }

    public void setIdEstudios(Integer idEstudios) {
        this.idEstudios = idEstudios;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Usuario getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(Usuario usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudios != null ? idEstudios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudios)) {
            return false;
        }
        Estudios other = (Estudios) object;
        if ((this.idEstudios == null && other.idEstudios != null) || (this.idEstudios != null && !this.idEstudios.equals(other.idEstudios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "g01.entity.Estudios[ idEstudios=" + idEstudios + " ]";
    }
    
}
