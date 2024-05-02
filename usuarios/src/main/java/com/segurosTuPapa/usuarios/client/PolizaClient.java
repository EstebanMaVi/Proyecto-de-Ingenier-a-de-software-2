package com.segurosTuPapa.usuarios.client;

import com.segurosTuPapa.usuarios.dto.PolizaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "polizas",url = "localhost:8070/api/polizas")
public interface PolizaClient {

    @GetMapping("/buscar-por-listId/{lista}")
    List<PolizaDTO>findAllPolizasByUsuario(@PathVariable("lista") List<Long> lista);

}
