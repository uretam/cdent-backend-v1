package com.cdent.pacientes.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "contactos_emergencia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactoEmergencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contacto")
    private Long idContacto;

    @Column(name = "nombre_contacto")
    @NotBlank
    private String nombreContacto;

    @Column(name = "telefono_contacto")
    @NotBlank
    private String telefonoContacto;

    @Column(name = "parentesco")
    @NotBlank
    private String parentesco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente", nullable = false)
    @NotNull
    @JsonBackReference
    @ToString.Exclude
    private Paciente paciente;

    @JsonProperty("idPaciente")
    public Long getIdPaciente() {
        return paciente != null ? paciente.getIdPaciente() : null;
    }

    @JsonProperty("idPaciente")
    public void setIdPaciente(Long idPaciente) {
        if (idPaciente == null) {
            this.paciente = null;
            return;
        }
        Paciente ref = new Paciente();
        ref.setIdPaciente(idPaciente);
        this.paciente = ref;
    }

}
