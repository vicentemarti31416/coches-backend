package com.vicente.microserviciocoches.service;

import com.vicente.microserviciocoches.entity.Coche;
import com.vicente.microserviciocommons.service.CommonService;

import java.util.List;

public interface CocheService extends CommonService<Coche> {

    public List<Coche> findByMarcaAndModeloAndKilometros(String marca, String modelo, String version, String motor, String cambio, String color, Integer knHasta, Integer precioHasta);
}
