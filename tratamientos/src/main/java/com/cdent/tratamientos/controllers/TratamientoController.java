package com.cdent.tratamientos.controllers;

import com.cdent.tratamientos.models.Tratamiento;
import com.cdent.tratamientos.services.TratamientoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

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
