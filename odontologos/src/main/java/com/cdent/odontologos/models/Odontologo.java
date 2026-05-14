package com.cdent.odontologos.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "odontologos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_odontologo")
    private Long idOdontologo;

    @Column(name = "rut", unique = true, nullable = false)
    @NotBlank
    private String rut;

    @Column(name = "nombres")
    @NotBlank
    private String nombres;

    @Column(name = "apellidos")
    @NotBlank
    private String apellidos;

    @Column(name = "especialidad")
    @NotBlank
    private String especialidad;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "activo")
    @NotNull
    private Boolean activo;

}
