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
@Table(name = "tipodeavion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodeavion.findAll", query = "SELECT t FROM Tipodeavion t")
    , @NamedQuery(name = "Tipodeavion.findByTipo", query = "SELECT t FROM Tipodeavion t WHERE t.tipo = :tipo")
    , @NamedQuery(name = "Tipodeavion.findByDescripcion", query = "SELECT t FROM Tipodeavion t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "Tipodeavion.findByCantFilas", query = "SELECT t FROM Tipodeavion t WHERE t.cantFilas = :cantFilas")
    , @NamedQuery(name = "Tipodeavion.findByCantCol", query = "SELECT t FROM Tipodeavion t WHERE t.cantCol = :cantCol")})
public class Tipodeavion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Tipo")
    private String tipo;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "CantFilas")
    private Integer cantFilas;
    @Column(name = "CantCol")
    private Integer cantCol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAvion")
    private Collection<Avion> avionCollection;

    public Tipodeavion() {
    }

    public Tipodeavion(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantFilas() {
        return cantFilas;
    }

    public void setCantFilas(Integer cantFilas) {
        this.cantFilas = cantFilas;
    }

    public Integer getCantCol() {
        return cantCol;
    }

    public void setCantCol(Integer cantCol) {
        this.cantCol = cantCol;
    }

    @XmlTransient
    public Collection<Avion> getAvionCollection() {
        return avionCollection;
    }

    public void setAvionCollection(Collection<Avion> avionCollection) {
        this.avionCollection = avionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipo != null ? tipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipodeavion)) {
            return false;
        }
        Tipodeavion other = (Tipodeavion) object;
        if ((this.tipo == null && other.tipo != null) || (this.tipo != null && !this.tipo.equals(other.tipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aerolinea.logica.Tipodeavion[ tipo=" + tipo + " ]";
    }
    
}
