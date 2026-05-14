package com.cdent.odontologos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cdent.odontologos.models.Odontologo;
import com.cdent.odontologos.repositories.OdontologoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OdontologoService {

    private final OdontologoRepository odontologoRepository;

    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public List<Odontologo> findAll() {
        return odontologoRepository.findAll();
    }

    public Optional<Odontologo> findById(Long id) {
        return odontologoRepository.findById(id);
    }

    public Odontologo save(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    public Optional<Odontologo> update(Long id, Odontologo odontologo) {
        return odontologoRepository.findById(id).map(existing -> {
            odontologo.setIdOdontologo(existing.getIdOdontologo());
            return odontologoRepository.save(odontologo);
        });
    }

    public void deleteById(Long id) {
        odontologoRepository.deleteById(id);
    }
}
