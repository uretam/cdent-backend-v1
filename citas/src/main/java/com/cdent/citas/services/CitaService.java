package com.cdent.citas.services;

import com.cdent.citas.models.Cita;
import com.cdent.citas.repositories.CitaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CitaService {

    private final CitaRepository citaRepository;

    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public List<Cita> findAll() {
        return citaRepository.findAll();
    }

    public Optional<Cita> findById(Long id) {
        return citaRepository.findById(id);
    }

    public Cita save(Cita cita) {
        return citaRepository.save(cita);
    }

    public Optional<Cita> update(Long id, Cita cita) {
        return citaRepository.findById(id).map(existing -> {
            cita.setIdCita(existing.getIdCita());
            return citaRepository.save(cita);
        });
    }

    public void deleteById(Long id) {
        citaRepository.deleteById(id);
    }

    public List<Cita> findByPacienteId(Long idPaciente) {
        return citaRepository.findByIdPaciente(idPaciente);
    }

    public List<Cita> findByOdontologoId(Long idOdontologo) {
        return citaRepository.findByIdOdontologo(idOdontologo);
    }
}
