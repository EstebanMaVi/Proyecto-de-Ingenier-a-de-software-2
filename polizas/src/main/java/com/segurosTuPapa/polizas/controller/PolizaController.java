package com.segurosTuPapa.polizas.controller;

import com.segurosTuPapa.polizas.entities.Poliza;
import com.segurosTuPapa.polizas.service.IPolizaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polizas")
public class PolizaController  {

    @Autowired
    private IPolizaService polizaService;

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePoliza(@RequestBody Poliza poliza){
        polizaService.save(poliza);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllPoliza(){
        return  ResponseEntity.ok(polizaService.findAll());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(polizaService.findById(id));
    }

    @GetMapping("/buscar-por-listId/{lista}")
    public ResponseEntity<?>findByListId(@PathVariable("lista") List<Long> lista){
        return ResponseEntity.ok(polizaService.findByListIdPoliza(lista));

    }
}
