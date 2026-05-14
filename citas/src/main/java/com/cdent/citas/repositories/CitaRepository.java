package com.cdent.citas.repositories;

import com.cdent.citas.models.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByIdPaciente(Long idPaciente);
    List<Cita> findByIdOdontologo(Long idOdontologo);
}
