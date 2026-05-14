package com.cdent.citas.clients;

import com.cdent.citas.clients.dto.PacienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pacientes-client", url = "${clients.pacientes.url:http://localhost:9081}")
public interface PacienteClient {

    @GetMapping("/api/pacientes/{id}")
    PacienteDTO getPacienteById(@PathVariable("id") Long id);

}
