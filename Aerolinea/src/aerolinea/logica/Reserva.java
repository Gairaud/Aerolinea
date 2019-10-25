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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r")
    , @NamedQuery(name = "Reserva.findByNumero", query = "SELECT r FROM Reserva r WHERE r.numero = :numero")
    , @NamedQuery(name = "Reserva.findByCantAsientos", query = "SELECT r FROM Reserva r WHERE r.cantAsientos = :cantAsientos")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Numero")
    private Integer numero;
    @Column(name = "CantAsientos")
    private Integer cantAsientos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reserva")
    private Collection<Tiquete> tiqueteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reserva")
    private Collection<Usuario> usuarioCollection;
    @JoinColumn(name = "TipoPago", referencedColumnName = "Codigo")
    @ManyToOne(optional = false)
    private Tipodepago tipoPago;
    @JoinColumn(name = "Viaje", referencedColumnName = "Numero")
    @ManyToOne(optional = false)
    private Viaje viaje;

    public Reserva() {
    }

    public Reserva(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCantAsientos() {
        return cantAsientos;
    }

    public void setCantAsientos(Integer cantAsientos) {
        this.cantAsientos = cantAsientos;
    }

    @XmlTransient
    public Collection<Tiquete> getTiqueteCollection() {
        return tiqueteCollection;
    }

    public void setTiqueteCollection(Collection<Tiquete> tiqueteCollection) {
        this.tiqueteCollection = tiqueteCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    public Tipodepago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(Tipodepago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aerolinea.logica.Reserva[ numero=" + numero + " ]";
    }
    
}
