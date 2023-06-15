package ec.edu.espe.arquitectura.examen.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "IMPUESTO_PORCENTAJE")
public class OfiEdificio {
    @EmbeddedId
    private OfiEdificioPK pk;

    @Column(name = "NOMBRE", length = 128, nullable = false)
    private String nombre;

    @Column(name = "PISOS", nullable = false)
    private Integer pisos;

    @Column(name = "SUPERFICIE", precision = 7, scale = 2, nullable = false)
    private BigDecimal superficie;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    @ManyToOne
    @JoinColumn(name = "COD_SEDE", referencedColumnName = "COD_SEDE", insertable = false, updatable = false)
    private OfiSede ofiSede;
}
