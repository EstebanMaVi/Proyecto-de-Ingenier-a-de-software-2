package com.segurosTuPapa.polizas.persistence;

import com.segurosTuPapa.polizas.entities.Poliza;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolizaRepository extends CrudRepository<Poliza, Long> {


}
