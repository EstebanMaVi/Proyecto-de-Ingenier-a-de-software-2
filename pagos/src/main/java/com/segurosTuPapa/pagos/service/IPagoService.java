package com.segurosTuPapa.pagos.service;

import com.segurosTuPapa.pagos.entities.Pago;

import java.util.List;

public interface IPagoService {
    List<Pago> findAll();

    Pago findById(Long id);

    void save(Pago pago);
}
