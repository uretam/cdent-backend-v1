package com.cdent.pacientes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cdent.pacientes.models.ContactoEmergencia;
import com.cdent.pacientes.repositories.ContactoEmergenciaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ContactoEmergenciaService {

    private final ContactoEmergenciaRepository contactoRepository;

    public ContactoEmergenciaService(ContactoEmergenciaRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    public List<ContactoEmergencia> findAll() {
        return contactoRepository.findAll();
    }

    public Optional<ContactoEmergencia> findById(Long id) {
        return contactoRepository.findById(id);
    }

    public ContactoEmergencia save(ContactoEmergencia contacto) {
        return contactoRepository.save(contacto);
    }

    public Optional<ContactoEmergencia> update(Long id, ContactoEmergencia contacto) {
        return contactoRepository.findById(id).map(existing -> {
            contacto.setIdContacto(existing.getIdContacto());
            return contactoRepository.save(contacto);
        });
    }

    public void deleteById(Long id) {
        contactoRepository.deleteById(id);
    }
}
