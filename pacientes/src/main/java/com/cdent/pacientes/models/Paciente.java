package com.cdent.pacientes.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pacientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long idPaciente;

    @Column(name = "rut", unique = true, nullable = false)
    @NotBlank
    private String rut;

    @Column(name = "nombres")
    @NotBlank
    private String nombres;

    @Column(name = "apellidos")
    @NotBlank
    private String apellidos;

    @Column(name = "fecha_nacimiento")
    @NotNull
    private LocalDate fechaNacimiento;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "activo")
    @NotNull
    private Boolean activo;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    @Valid
    @JsonManagedReference
    @ToString.Exclude
    private List<ContactoEmergencia> contactosEmergencia = new ArrayList<>();

}
