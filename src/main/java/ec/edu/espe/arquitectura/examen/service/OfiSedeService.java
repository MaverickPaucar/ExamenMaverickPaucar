package ec.edu.espe.arquitectura.examen.service;

import java.util.Optional;

import org.antlr.v4.runtime.atn.SemanticContext.OR;
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
        OfiSede ofiSedeTmp = this.ofiSedeRepository
                .findByCodigoInstitucionAndEsPrincipal(ofiSede.getCodigoInstitucion(), ofiSede.getEsPrincipal());
        if (ofiSedeTmp == null || this.ofiSedeRepository.existsById(ofiSede.getCodigo())) {
            return this.ofiSedeRepository.save(ofiSede);
        } else {
            throw new RuntimeException("Ya existe la SEDE o la ");
        }
    }

}
