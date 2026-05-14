package com.cdent.citas.controllers;

import com.cdent.citas.models.Cita;
import com.cdent.citas.services.CitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    public List<Cita> getAll() {
        return citaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> getById(@PathVariable Long id) {
        return citaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cita> create(@Valid @RequestBody Cita cita) {
        Cita saved = citaService.save(cita);
        return ResponseEntity.created(URI.create("/api/citas/" + saved.getIdCita())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cita> update(@PathVariable Long id, @Valid @RequestBody Cita cita) {
        return citaService.update(id, cita)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        citaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/paciente/{idPaciente}")
    public List<Cita> getByPaciente(@PathVariable Long idPaciente) {
        return citaService.findByPacienteId(idPaciente);
    }

    @GetMapping("/odontologo/{idOdontologo}")
    public List<Cita> getByOdontologo(@PathVariable Long idOdontologo) {
        return citaService.findByOdontologoId(idOdontologo);
    }
}
