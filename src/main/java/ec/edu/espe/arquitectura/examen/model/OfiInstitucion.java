package ec.edu.espe.arquitectura.examen.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "OFI_INSTITUCION")
public class OfiInstitucion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_INSTITUCION")
    private Integer codigo;

    @Column(name = "RUC", length = 13, nullable = false)
    private String ruc;

    @Column(name = "RAZON_SOCIAL", length = 250, nullable = false)
    private String razonSocial;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    public OfiInstitucion() {
    }

    public OfiInstitucion(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OfiInstitucion other = (OfiInstitucion) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OfiInstitucion [codigo=" + codigo + ", ruc=" + ruc + ", razonSocial=" + razonSocial + ", version="
                + version + "]";
    }

}
