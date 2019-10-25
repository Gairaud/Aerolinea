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
@Table(name = "vuelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vuelo.findAll", query = "SELECT v FROM Vuelo v")
    , @NamedQuery(name = "Vuelo.findById", query = "SELECT v FROM Vuelo v WHERE v.id = :id")
    , @NamedQuery(name = "Vuelo.findByIdaVenida", query = "SELECT v FROM Vuelo v WHERE v.idaVenida = :idaVenida")
    , @NamedQuery(name = "Vuelo.findByDuracion", query = "SELECT v FROM Vuelo v WHERE v.duracion = :duracion")
    , @NamedQuery(name = "Vuelo.findByHoraSalida", query = "SELECT v FROM Vuelo v WHERE v.horaSalida = :horaSalida")})
public class Vuelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private String id;
    @Column(name = "IdaVenida")
    private Short idaVenida;
    @Column(name = "Duracion")
    private Integer duracion;
    @Column(name = "HoraSalida")
    @Temporal(TemporalType.TIME)
    private Date horaSalida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vuelo")
    private Collection<Viaje> viajeCollection;
    @JoinColumn(name = "Avion", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Avion avion;
    @JoinColumn(name = "Origen", referencedColumnName = "Codigo")
    @ManyToOne(optional = false)
    private Ciudad origen;
    @JoinColumn(name = "Destino", referencedColumnName = "Codigo")
    @ManyToOne(optional = false)
    private Ciudad destino;

    public Vuelo() {
    }

    public Vuelo(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Short getIdaVenida() {
        return idaVenida;
    }

    public void setIdaVenida(Short idaVenida) {
        this.idaVenida = idaVenida;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    @XmlTransient
    public Collection<Viaje> getViajeCollection() {
        return viajeCollection;
    }

    public void setViajeCollection(Collection<Viaje> viajeCollection) {
        this.viajeCollection = viajeCollection;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
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
        if (!(object instanceof Vuelo)) {
            return false;
        }
        Vuelo other = (Vuelo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aerolinea.logica.Vuelo[ id=" + id + " ]";
    }
    
}
