package ec.edu.espe.arquitectura.examen.service;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.examen.model.OfiSede;
import ec.edu.espe.arquitectura.examen.repository.OfiSedeRepository;
import jakarta.transaction.Transactional;

@Service
public class OfiSedeService {

    private final OfiSedeRepository ofiSedeRepository;

    public OfiSedeService(OfiSedeRepository ofiSedeRepository) {
        this.ofiSedeRepository = ofiSedeRepository;
    }

    @Transactional
    public OfiSede create(OfiSede ofiSede) {
        if (!this.ofiSedeRepository.existsById(ofiSede.getCodigo())) {
            return this.ofiSedeRepository.save(ofiSede);
        } else {
            throw new RuntimeException("Ya existe la sede");
        }
    }

}
