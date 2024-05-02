package com.segurosTuPapa.usuarios.service;

import com.segurosTuPapa.usuarios.dto.PolizaDTO;
import com.segurosTuPapa.usuarios.entities.Usuario;
import com.segurosTuPapa.usuarios.http.response.PolizaByUsuarioResponse;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> findAll();
    Usuario findById(Long id);
    void save(Usuario usuario);
    PolizaByUsuarioResponse findAllPolizasByUsuario (Long id);
}
