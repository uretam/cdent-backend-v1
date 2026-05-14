package com.cdent.citas.clients.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {
    private Long idPaciente;
    private String rut;
    private String nombres;
    private String apellidos;
    private String fechaNacimiento; // ISO date string
    private String email;
    private String telefono;
    private String direccion;
    private Boolean activo;
}
