package com.segurosTuPapa.pagos.persistence;

import com.segurosTuPapa.pagos.entities.Pago;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PagoRespository extends CrudRepository<Pago,Long> {

    //List<?> findAllByClienteId(Long clienteId);

}
