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
@Table(name = "experiencia_laboral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExperienciaLaboral.findAll", query = "SELECT e FROM ExperienciaLaboral e"),
    @NamedQuery(name = "ExperienciaLaboral.findByIdExperiencialaboral", query = "SELECT e FROM ExperienciaLaboral e WHERE e.idExperiencialaboral = :idExperiencialaboral"),
    @NamedQuery(name = "ExperienciaLaboral.findByFechaInicio", query = "SELECT e FROM ExperienciaLaboral e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "ExperienciaLaboral.findByFechaFin", query = "SELECT e FROM ExperienciaLaboral e WHERE e.fechaFin = :fechaFin"),
    @NamedQuery(name = "ExperienciaLaboral.findByEmpresa", query = "SELECT e FROM ExperienciaLaboral e WHERE e.empresa = :empresa"),
    @NamedQuery(name = "ExperienciaLaboral.findByUbicacion", query = "SELECT e FROM ExperienciaLaboral e WHERE e.ubicacion = :ubicacion"),
    @NamedQuery(name = "ExperienciaLaboral.findByDescripcion", query = "SELECT e FROM ExperienciaLaboral e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "ExperienciaLaboral.findByPuesto", query = "SELECT e FROM ExperienciaLaboral e WHERE e.puesto = :puesto"),
    @NamedQuery(name = "ExperienciaLaboral.findByWeb", query = "SELECT e FROM ExperienciaLaboral e WHERE e.web = :web")})
public class ExperienciaLaboral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idExperiencia_laboral")
    private Integer idExperiencialaboral;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Size(max = 45)
    @Column(name = "empresa")
    private String empresa;
    @Size(max = 45)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "puesto")
    private String puesto;
    @Size(max = 45)
    @Column(name = "web")
    private String web;
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuarioidUsuario;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(Integer idExperiencialaboral) {
        this.idExperiencialaboral = idExperiencialaboral;
    }

    public Integer getIdExperiencialaboral() {
        return idExperiencialaboral;
    }

    public void setIdExperiencialaboral(Integer idExperiencialaboral) {
        this.idExperiencialaboral = idExperiencialaboral;
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
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
        hash += (idExperiencialaboral != null ? idExperiencialaboral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExperienciaLaboral)) {
            return false;
        }
        ExperienciaLaboral other = (ExperienciaLaboral) object;
        if ((this.idExperiencialaboral == null && other.idExperiencialaboral != null) || (this.idExperiencialaboral != null && !this.idExperiencialaboral.equals(other.idExperiencialaboral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "g01.entity.ExperienciaLaboral[ idExperiencialaboral=" + idExperiencialaboral + " ]";
    }
    
}
