package com.cdent.pacientes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cdent.pacientes.models.Paciente;
import com.cdent.pacientes.repositories.PacienteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> findById(Long id) {
        return pacienteRepository.findById(id);
    }

    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> update(Long id, Paciente paciente) {
        return pacienteRepository.findById(id).map(existing -> {
            paciente.setIdPaciente(existing.getIdPaciente());
            return pacienteRepository.save(paciente);
        });
    }

    public void deleteById(Long id) {
        pacienteRepository.deleteById(id);
    }
}
