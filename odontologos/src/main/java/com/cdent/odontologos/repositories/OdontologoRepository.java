package com.cdent.odontologos.repositories;

import com.cdent.odontologos.models.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {
    boolean existsByRut(String rut);
}
