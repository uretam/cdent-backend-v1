package com.cdent.citas.clients;

import com.cdent.citas.clients.dto.OdontologoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "odontologos-client", url = "${clients.odontologos.url:http://localhost:9082}")
public interface OdontologoClient {

    @GetMapping("/api/odontologos/{id}")
    OdontologoDTO getOdontologoById(@PathVariable("id") Long id);

}
