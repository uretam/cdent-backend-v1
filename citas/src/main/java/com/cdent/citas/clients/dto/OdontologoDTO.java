package com.cdent.citas.clients.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OdontologoDTO {
    private Long idOdontologo;
    private String rut;
    private String nombres;
    private String apellidos;
    private String especialidad;
    private String email;
    private String telefono;
    private Boolean activo;
}
