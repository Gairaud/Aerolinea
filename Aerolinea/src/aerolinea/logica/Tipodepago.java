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
@Table(name = "tipodepago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodepago.findAll", query = "SELECT t FROM Tipodepago t")
    , @NamedQuery(name = "Tipodepago.findByCodigo", query = "SELECT t FROM Tipodepago t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Tipodepago.findByDescripcion", query = "SELECT t FROM Tipodepago t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "Tipodepago.findByMontoTotal", query = "SELECT t FROM Tipodepago t WHERE t.montoTotal = :montoTotal")})
public class Tipodepago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Codigo")
    private String codigo;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "MontoTotal")
    private Short montoTotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPago")
    private Collection<Reserva> reservaCollection;

    public Tipodepago() {
    }

    public Tipodepago(String codigo) {
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

    public Short getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Short montoTotal) {
        this.montoTotal = montoTotal;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
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
        if (!(object instanceof Tipodepago)) {
            return false;
        }
        Tipodepago other = (Tipodepago) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aerolinea.logica.Tipodepago[ codigo=" + codigo + " ]";
    }
    
}
