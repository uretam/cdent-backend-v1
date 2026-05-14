package com.cdent.citas.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "citas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long idCita;

    // Logical FK to pacientes microservice
    @Column(name = "id_paciente")
    @NotNull
    private Long idPaciente;

    // Logical FK to odontologos microservice
    @Column(name = "id_odontologo")
    @NotNull
    private Long idOdontologo;

    @Column(name = "fecha_hora")
    @NotNull
    private LocalDateTime fechaHora;

    @Column(name = "motivo")
    @NotBlank
    private String motivo;

    @Column(name = "estado")
    @NotBlank
    private String estado;

}
