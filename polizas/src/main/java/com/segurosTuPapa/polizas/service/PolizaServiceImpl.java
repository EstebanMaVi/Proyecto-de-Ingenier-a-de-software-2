package com.segurosTuPapa.polizas.service;

import com.segurosTuPapa.polizas.entities.Poliza;
import com.segurosTuPapa.polizas.persistence.PolizaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PolizaServiceImpl implements IPolizaService{

    @Autowired
    private PolizaRepository polizaRepository;

    @Override
    public List<Poliza> findAll() {
        return (List<Poliza>) polizaRepository.findAll();
    }

    @Override
    public Poliza findById(Long id) {
        return polizaRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Poliza poliza) {
        polizaRepository.save(poliza);

    }
    @Override
    public List<Optional<Poliza>> findByListIdPoliza(List<Long> idPolizas) {
        List<Optional<Poliza>> polizas = new ArrayList<>();
        for (Long idPoliza:idPolizas){
            Optional<Poliza> poliza = polizaRepository.findById(idPoliza);
            polizas.add(poliza);
        }
        return polizas;
    }
}
