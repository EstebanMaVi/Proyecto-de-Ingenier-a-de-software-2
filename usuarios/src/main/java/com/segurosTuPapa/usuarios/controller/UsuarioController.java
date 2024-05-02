package com.segurosTuPapa.usuarios.controller;

import com.segurosTuPapa.usuarios.entities.Usuario;
import com.segurosTuPapa.usuarios.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUsuario(@RequestBody Usuario usuario){
        usuarioService.save(usuario);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllUsuarios(){
        return  ResponseEntity.ok(usuarioService.findAll());
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @GetMapping("/buscar-por-listId/{id}")
    public ResponseEntity<?> findAllPolizasByUsuario(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.findAllPolizasByUsuario(id));
    }
}
