package ec.edu.espe.arquitectura.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.espe.arquitectura.examen.model.OfiEdificioPK;

@Repository
public interface OfiEdificioRepository extends JpaRepository<OfiEdificioRepository, OfiEdificioPK> {
}
