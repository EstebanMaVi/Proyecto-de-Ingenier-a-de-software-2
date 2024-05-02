package com.segurosTuPapa.usuarios.http.response;

import com.segurosTuPapa.usuarios.dto.PolizaDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PolizaByUsuarioResponse {

    private Long idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private List<PolizaDTO> polizaDTOList;
}
