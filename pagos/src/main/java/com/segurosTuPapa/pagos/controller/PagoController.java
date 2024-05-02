package com.segurosTuPapa.pagos.controller;

import com.segurosTuPapa.pagos.entities.Pago;
import com.segurosTuPapa.pagos.service.IPagoService;
import jakarta.ws.rs.GET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final IPagoService pagoService;

    @Autowired
    public PagoController(IPagoService pagoService) {
        this.pagoService = pagoService;
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePago(@RequestBody Pago pago){
        pagoService.save(pago);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllPago(){
        return ResponseEntity.ok(pagoService.findAll());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(pagoService.findById(id));
    }

}
