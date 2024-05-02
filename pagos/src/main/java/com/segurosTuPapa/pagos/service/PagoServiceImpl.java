package com.segurosTuPapa.pagos.service;

import com.segurosTuPapa.pagos.entities.Pago;
import com.segurosTuPapa.pagos.persistence.PagoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoServiceImpl implements IPagoService{


    @Autowired
    private PagoRespository pagoRespository;

    @Override
    public List<Pago> findAll() {
        return (List<Pago>) pagoRespository.findAll();
    }

    @Override
    public Pago findById(Long id) {
        return pagoRespository.findById(id).orElseThrow();
    }

    @Override
    public void save(Pago pago) {
        pagoRespository.save(pago);
    }
}
