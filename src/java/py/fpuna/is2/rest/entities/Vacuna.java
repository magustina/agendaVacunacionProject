package py.fpuna.is2.rest.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Agustina Trinidad
 */
@Entity
@Table(name = "vacuna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacuna.findAll", query = "SELECT v FROM Vacuna v"),
    @NamedQuery(name = "Vacuna.findByIdVacuna", query = "SELECT v FROM Vacuna v WHERE v.idVacuna = :idVacuna"),
    @NamedQuery(name = "Vacuna.findByNombre", query = "SELECT v FROM Vacuna v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "Vacuna.findByCantidadDosis", query = "SELECT v FROM Vacuna v WHERE v.cantidadDosis = :cantidadDosis"),
    @NamedQuery(name = "Vacuna.findByPreviene", query = "SELECT v FROM Vacuna v WHERE v.previene = :previene")})
public class Vacuna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vacuna")
    private Integer idVacuna;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "cantidad_dosis")
    private Integer cantidadDosis;
    @Column(name = "previene")
    private String previene;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVacuna")
    private Collection<Registro> registroCollection;

    public Vacuna() {
    }

    public Vacuna(Integer idVacuna) {
        this.idVacuna = idVacuna;
    }

    public Integer getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(Integer idVacuna) {
        this.idVacuna = idVacuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadDosis() {
        return cantidadDosis;
    }

    public void setCantidadDosis(Integer cantidadDosis) {
        this.cantidadDosis = cantidadDosis;
    }

    public String getPreviene() {
        return previene;
    }

    public void setPreviene(String previene) {
        this.previene = previene;
    }

    @XmlTransient
    public Collection<Registro> getRegistroCollection() {
        return registroCollection;
    }

    public void setRegistroCollection(Collection<Registro> registroCollection) {
        this.registroCollection = registroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVacuna != null ? idVacuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacuna)) {
            return false;
        }
        Vacuna other = (Vacuna) object;
        if ((this.idVacuna == null && other.idVacuna != null) || (this.idVacuna != null && !this.idVacuna.equals(other.idVacuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.fpuna.is2.rest.entities.Vacuna[ idVacuna=" + idVacuna + " ]";
    }
    
}
