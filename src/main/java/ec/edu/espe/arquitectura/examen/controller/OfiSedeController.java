package ec.edu.espe.arquitectura.examen.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.examen.model.OfiSede;
import ec.edu.espe.arquitectura.examen.service.OfiSedeService;

@RestController
@RequestMapping("/api/v1/sede")
public class OfiSedeController {
    private final OfiSedeService ofiSedeService;

    public OfiSedeController(OfiSedeService ofiSedeService) {
        this.ofiSedeService = ofiSedeService;
    }

    @PostMapping(value = "/create-sede")
    public ResponseEntity<OfiSede> create(@RequestBody OfiSede sede) {
        try {
            OfiSede ofiSedeTemp = this.ofiSedeService.create(sede);
            return ResponseEntity.ok(ofiSedeTemp);
        } catch (RuntimeException rte) {
            return ResponseEntity.badRequest().build();
        }

    }

}
