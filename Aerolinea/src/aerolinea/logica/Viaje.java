/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gaira
 */
@Entity
@Table(name = "viaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viaje.findAll", query = "SELECT v FROM Viaje v")
    , @NamedQuery(name = "Viaje.findByNumero", query = "SELECT v FROM Viaje v WHERE v.numero = :numero")
    , @NamedQuery(name = "Viaje.findByDisponibles", query = "SELECT v FROM Viaje v WHERE v.disponibles = :disponibles")
    , @NamedQuery(name = "Viaje.findByPrecio", query = "SELECT v FROM Viaje v WHERE v.precio = :precio")
    , @NamedQuery(name = "Viaje.findByFechaSalida", query = "SELECT v FROM Viaje v WHERE v.fechaSalida = :fechaSalida")
    , @NamedQuery(name = "Viaje.findByFechaRegreso", query = "SELECT v FROM Viaje v WHERE v.fechaRegreso = :fechaRegreso")})
public class Viaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Numero")
    private Integer numero;
    @Column(name = "Disponibles")
    private Integer disponibles;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Precio")
    private Float precio;
    @Column(name = "FechaSalida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Column(name = "FechaRegreso")
    @Temporal(TemporalType.DATE)
    private Date fechaRegreso;
    @JoinColumn(name = "Vuelo", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Vuelo vuelo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viaje")
    private Collection<Reserva> reservaCollection;

    public Viaje() {
    }

    public Viaje(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(Integer disponibles) {
        this.disponibles = disponibles;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaRegreso() {
        return fechaRegreso;
    }

    public void setFechaRegreso(Date fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
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
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viaje)) {
            return false;
        }
        Viaje other = (Viaje) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aerolinea.logica.Viaje[ numero=" + numero + " ]";
    }
    
}
