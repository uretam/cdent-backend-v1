package com.cdent.tratamientos.services;

import com.cdent.tratamientos.models.Tratamiento;
import com.cdent.tratamientos.repositories.TratamientoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TratamientoService {

    private final TratamientoRepository tratamientoRepository;

    public TratamientoService(TratamientoRepository tratamientoRepository) {
        this.tratamientoRepository = tratamientoRepository;
    }

    public List<Tratamiento> findAll() {
        return tratamientoRepository.findAll();
    }

    public Optional<Tratamiento> findById(Long id) {
        return tratamientoRepository.findById(id);
    }

    public Tratamiento save(Tratamiento tratamiento) {
        return tratamientoRepository.save(tratamiento);
    }

    public Optional<Tratamiento> update(Long id, Tratamiento tratamiento) {
        return tratamientoRepository.findById(id).map(existing -> {
            tratamiento.setIdTratamiento(existing.getIdTratamiento());
            return tratamientoRepository.save(tratamiento);
        });
    }

    public void deleteById(Long id) {
        tratamientoRepository.deleteById(id);
    }
}
