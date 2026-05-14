package com.cdent.pacientes.controllers;

import com.cdent.pacientes.models.ContactoEmergencia;
import com.cdent.pacientes.services.ContactoEmergenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pacientes/contactos")
public class ContactoEmergenciaController {

    private final ContactoEmergenciaService contactoService;

    public ContactoEmergenciaController(ContactoEmergenciaService contactoService) {
        this.contactoService = contactoService;
    }

    @GetMapping
    public List<ContactoEmergencia> getAll() {
        return contactoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactoEmergencia> getById(@PathVariable Long id) {
        return contactoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ContactoEmergencia> create(@Valid @RequestBody ContactoEmergencia contacto) {
        ContactoEmergencia saved = contactoService.save(contacto);
        return ResponseEntity.created(URI.create("/api/pacientes/contactos/" + saved.getIdContacto())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactoEmergencia> update(@PathVariable Long id, @Valid @RequestBody ContactoEmergencia contacto) {
        return contactoService.update(id, contacto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contactoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
