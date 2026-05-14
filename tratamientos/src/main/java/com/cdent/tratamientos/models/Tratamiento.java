package com.cdent.tratamientos.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "tratamientos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tratamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tratamiento")
    private Long idTratamiento;

    @Column(name = "nombre_tratamiento")
    @NotBlank
    private String nombreTratamiento;

    @Column(name = "descripcion")
    @NotBlank
    private String descripcion;

    @Column(name = "precio")
    @NotNull
    @PositiveOrZero
    private BigDecimal precio;

}
