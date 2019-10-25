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
@Table(name = "avion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avion.findAll", query = "SELECT a FROM Avion a")
    , @NamedQuery(name = "Avion.findById", query = "SELECT a FROM Avion a WHERE a.id = :id")
    , @NamedQuery(name = "Avion.findByMarca", query = "SELECT a FROM Avion a WHERE a.marca = :marca")
    , @NamedQuery(name = "Avion.findByAnnyo", query = "SELECT a FROM Avion a WHERE a.annyo = :annyo")})
public class Avion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private String id;
    @Column(name = "Marca")
    private String marca;
    @Column(name = "Annyo")
    private Integer annyo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avion")
    private Collection<Vuelo> vueloCollection;
    @JoinColumn(name = "TipoAvion", referencedColumnName = "Tipo")
    @ManyToOne(optional = false)
    private Tipodeavion tipoAvion;

    public Avion() {
    }

    public Avion(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAnnyo() {
        return annyo;
    }

    public void setAnnyo(Integer annyo) {
        this.annyo = annyo;
    }

    @XmlTransient
    public Collection<Vuelo> getVueloCollection() {
        return vueloCollection;
    }

    public void setVueloCollection(Collection<Vuelo> vueloCollection) {
        this.vueloCollection = vueloCollection;
    }

    public Tipodeavion getTipoAvion() {
        return tipoAvion;
    }

    public void setTipoAvion(Tipodeavion tipoAvion) {
        this.tipoAvion = tipoAvion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avion)) {
            return false;
        }
        Avion other = (Avion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aerolinea.logica.Avion[ id=" + id + " ]";
    }
    
}
