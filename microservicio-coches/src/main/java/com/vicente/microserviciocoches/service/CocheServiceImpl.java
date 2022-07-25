package com.vicente.microserviciocoches.service;

import com.vicente.microserviciocoches.entity.Coche;
import com.vicente.microserviciocoches.repository.CocheRepository;
import com.vicente.microserviciocommons.service.CommonServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocheServiceImpl extends CommonServiceImpl<Coche, CocheRepository> implements CocheService {

    @Override
    public List<Coche> findByMarcaAndModeloAndKilometros(String marca, String modelo, String version, String motor, String cambio, String color, Integer kmHasta, Integer precioHasta) {
        System.out.println(marca);
        List<Coche> coches = repository.findByMarcaAndModeloAndKilometros(marca, modelo, version, motor, cambio, color, kmHasta, precioHasta);
        System.out.println(coches);
        return coches;
    }
}
