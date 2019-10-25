/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gaira
 */
@Entity
@Table(name = "ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
    , @NamedQuery(name = "Ciudad.findByCodigo", query = "SELECT c FROM Ciudad c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Ciudad.findByDescripcion", query = "SELECT c FROM Ciudad c WHERE c.descripcion = :descripcion")})
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Codigo")
    private String codigo;
    @Column(name = "Descripcion")
    private String descripcion;
    @JoinColumn(name = "Pais", referencedColumnName = "Codigo")
    @ManyToOne(optional = false)
    private Pais pais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "origen")
    private Collection<Vuelo> vueloCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destino")
    private Collection<Vuelo> vueloCollection1;

    public Ciudad() {
    }

    public Ciudad(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @XmlTransient
    public Collection<Vuelo> getVueloCollection() {
        return vueloCollection;
    }

    public void setVueloCollection(Collection<Vuelo> vueloCollection) {
        this.vueloCollection = vueloCollection;
    }

    @XmlTransient
    public Collection<Vuelo> getVueloCollection1() {
        return vueloCollection1;
    }

    public void setVueloCollection1(Collection<Vuelo> vueloCollection1) {
        this.vueloCollection1 = vueloCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aerolinea.logica.Ciudad[ codigo=" + codigo + " ]";
    }
    
}
