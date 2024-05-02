package com.segurosTuPapa.polizas.service;

import com.segurosTuPapa.polizas.entities.Poliza;

import java.util.List;
import java.util.Optional;

public interface IPolizaService {

    List<Poliza> findAll();

    Poliza findById(Long id);

    void save(Poliza poliza);

    List<Optional<Poliza>> findByListIdPoliza(List<Long> idPolizas);
}
