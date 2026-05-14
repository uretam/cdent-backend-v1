package com.cdent.tratamientos.controllers;

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

import com.cdent.tratamientos.models.Tratamiento;
import com.cdent.tratamientos.services.TratamientoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tratamientos")
public class TratamientoController {

    private final TratamientoService tratamientoService;

    public TratamientoController(TratamientoService tratamientoService) {
        this.tratamientoService = tratamientoService;
    }

    @GetMapping
    public List<Tratamiento> getAll() {
        return tratamientoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tratamiento> getById(@PathVariable Long id) {
        return tratamientoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tratamiento> create(@Valid @RequestBody Tratamiento tratamiento) {
        Tratamiento saved = tratamientoService.save(tratamiento);
        return ResponseEntity.created(URI.create("/api/tratamientos/" + saved.getIdTratamiento())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tratamiento> update(@PathVariable Long id, @Valid @RequestBody Tratamiento tratamiento) {
        return tratamientoService.update(id, tratamiento)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tratamientoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
