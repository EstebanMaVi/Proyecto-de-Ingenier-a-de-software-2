package com.segurosTuPapa.pagos.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "usuarios", url = "http://localhost:8090")
public interface UsuarioClient {
}
