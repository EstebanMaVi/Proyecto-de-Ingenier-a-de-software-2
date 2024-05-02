package com.segurosTuPapa.usuarios.service;

import com.segurosTuPapa.usuarios.client.PolizaClient;
import com.segurosTuPapa.usuarios.dto.PolizaDTO;
import com.segurosTuPapa.usuarios.entities.Usuario;
import com.segurosTuPapa.usuarios.http.response.PolizaByUsuarioResponse;
import com.segurosTuPapa.usuarios.persistence.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PolizaClient polizaClient;

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public PolizaByUsuarioResponse findAllPolizasByUsuario(Long id) {


        //Consultar usuario
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        List<Long> polizasId = usuario.getPolizasId();

        //Consultar las polizas
        List<PolizaDTO> polizaDTOList = polizaClient.findAllPolizasByUsuario(polizasId);

        return PolizaByUsuarioResponse.builder()
                .idUsuario(usuario.getId())
                .nombreUsuario(usuario.getNombre())
                .apellidoUsuario(usuario.getApellido())
                .polizaDTOList(polizaDTOList)
                .build();
    }

}
