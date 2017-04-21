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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
    @NamedQuery(name = "Login.findByUsuario1", query = "SELECT l FROM Login l WHERE l.usuario1 = :usuario1"),
    @NamedQuery(name = "Login.findByContrase\u00f1a", query = "SELECT l FROM Login l WHERE l.contrase\u00f1a = :contrase\u00f1a")})
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usuario")
    private String usuario1;
    @Size(max = 45)
    @Column(name = "contrase\u00f1a")
    private String contraseña;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "loginusuario")
    private Usuario usuario;

    public Login() {
    }

    public Login(String usuario1) {
        this.usuario1 = usuario1;
    }

    public String getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(String usuario1) {
        this.usuario1 = usuario1;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario1 != null ? usuario1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.usuario1 == null && other.usuario1 != null) || (this.usuario1 != null && !this.usuario1.equals(other.usuario1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "g01.entity.Login[ usuario1=" + usuario1 + " ]";
    }
    
}
