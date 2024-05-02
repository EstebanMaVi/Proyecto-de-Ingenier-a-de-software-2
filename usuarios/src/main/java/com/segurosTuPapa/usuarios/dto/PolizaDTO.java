package com.segurosTuPapa.usuarios.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PolizaDTO {

    private String tipo;
    private String descripcion;
    private String cobertura;
    private Double montoAsegurado;
    private Double costo;
    private String fechaInicio;
    private String fechaFinal;
}
