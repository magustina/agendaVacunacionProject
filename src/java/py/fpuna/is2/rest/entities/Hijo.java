package py.fpuna.is2.rest.entities;

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
 * @author Agustina Trinaidad
 */
@Entity
@Table(name = "hijo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hijo.findAll", query = "SELECT h FROM Hijo h"),
    @NamedQuery(name = "Hijo.findByIdHijo", query = "SELECT h FROM Hijo h WHERE h.idHijo = :idHijo"),
    @NamedQuery(name = "Hijo.findByCedula", query = "SELECT h FROM Hijo h WHERE h.cedula = :cedula"),
    @NamedQuery(name = "Hijo.findByNombre", query = "SELECT h FROM Hijo h WHERE h.nombre = :nombre"),
    @NamedQuery(name = "Hijo.findByApellido", query = "SELECT h FROM Hijo h WHERE h.apellido = :apellido"),
    @NamedQuery(name = "Hijo.findByFechaNacimiento", query = "SELECT h FROM Hijo h WHERE h.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Hijo.findByLugarNacimiento", query = "SELECT h FROM Hijo h WHERE h.lugarNacimiento = :lugarNacimiento"),
    @NamedQuery(name = "Hijo.findBySexo", query = "SELECT h FROM Hijo h WHERE h.sexo = :sexo"),
    @NamedQuery(name = "Hijo.findByNacionalidad", query = "SELECT h FROM Hijo h WHERE h.nacionalidad = :nacionalidad"),
    @NamedQuery(name = "Hijo.findByDireccion", query = "SELECT h FROM Hijo h WHERE h.direccion = :direccion"),
    @NamedQuery(name = "Hijo.findByDepartamento", query = "SELECT h FROM Hijo h WHERE h.departamento = :departamento"),
    @NamedQuery(name = "Hijo.findByMunicipio", query = "SELECT h FROM Hijo h WHERE h.municipio = :municipio"),
    @NamedQuery(name = "Hijo.findByBarrio", query = "SELECT h FROM Hijo h WHERE h.barrio = :barrio"),
    @NamedQuery(name = "Hijo.findByReferenciaDomicilio", query = "SELECT h FROM Hijo h WHERE h.referenciaDomicilio = :referenciaDomicilio"),
    @NamedQuery(name = "Hijo.findByResponsable", query = "SELECT h FROM Hijo h WHERE h.responsable = :responsable"),
    @NamedQuery(name = "Hijo.findByTelefono", query = "SELECT h FROM Hijo h WHERE h.telefono = :telefono"),
    @NamedQuery(name = "Hijo.findBySeguroMedico", query = "SELECT h FROM Hijo h WHERE h.seguroMedico = :seguroMedico"),
    @NamedQuery(name = "Hijo.findByAlergia", query = "SELECT h FROM Hijo h WHERE h.alergia = :alergia")})
public class Hijo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_hijo")
    private Integer idHijo;
    @Column(name = "cedula")
    private Integer cedula;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "lugar_nacimiento")
    private String lugarNacimiento;
    @Column(name = "sexo")
    private Integer sexo;
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "departamento")
    private String departamento;
    @Column(name = "municipio")
    private String municipio;
    @Column(name = "barrio")
    private String barrio;
    @Column(name = "referencia_domicilio")
    private String referenciaDomicilio;
    @Column(name = "responsable")
    private String responsable;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "seguro_medico")
    private Integer seguroMedico;
    @Column(name = "alergia")
    private String alergia;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHijo")
    private Collection<Registro> registroCollection;

    public Hijo() {
    }

    public Hijo(Integer idHijo) {
        this.idHijo = idHijo;
    }

    public Integer getIdHijo() {
        return idHijo;
    }

    public void setIdHijo(Integer idHijo) {
        this.idHijo = idHijo;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getReferenciaDomicilio() {
        return referenciaDomicilio;
    }

    public void setReferenciaDomicilio(String referenciaDomicilio) {
        this.referenciaDomicilio = referenciaDomicilio;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getSeguroMedico() {
        return seguroMedico;
    }

    public void setSeguroMedico(Integer seguroMedico) {
        this.seguroMedico = seguroMedico;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        hash += (idHijo != null ? idHijo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hijo)) {
            return false;
        }
        Hijo other = (Hijo) object;
        if ((this.idHijo == null && other.idHijo != null) || (this.idHijo != null && !this.idHijo.equals(other.idHijo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.fpuna.is2.rest.entities.Hijo[ idHijo=" + idHijo + " ]";
    }
    
}
