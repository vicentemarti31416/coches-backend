package com.vicente.microserviciocoches.service;

import com.vicente.microserviciocoches.entity.Marca;
import com.vicente.microserviciocoches.entity.Modelo;
import com.vicente.microserviciocommons.service.CommonService;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModeloService extends CommonService<Modelo> {

    List<Modelo> findModeloByMarcaId(@Param("marcaId") Long marcaId);

}
