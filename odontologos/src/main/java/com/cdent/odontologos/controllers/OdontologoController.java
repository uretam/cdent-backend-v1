package com.cdent.odontologos.controllers;

import com.cdent.odontologos.models.Odontologo;
import com.cdent.odontologos.services.OdontologoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/odontologos")
public class OdontologoController {

    private final OdontologoService odontologoService;

    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping
    public List<Odontologo> getAll() {
        return odontologoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> getById(@PathVariable Long id) {
        return odontologoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Odontologo> create(@Valid @RequestBody Odontologo odontologo) {
        Odontologo saved = odontologoService.save(odontologo);
        return ResponseEntity.created(URI.create("/api/odontologos/" + saved.getIdOdontologo())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Odontologo> update(@PathVariable Long id, @Valid @RequestBody Odontologo odontologo) {
        return odontologoService.update(id, odontologo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        odontologoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
