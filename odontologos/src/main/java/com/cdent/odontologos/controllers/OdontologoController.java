package com.cdent.odontologos.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdent.odontologos.models.Odontologo;
import com.cdent.odontologos.services.OdontologoService;

import jakarta.validation.Valid;

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
