package com.vicente.microserviciocoches.service;

import com.vicente.microserviciocoches.entity.Marca;
import com.vicente.microserviciocoches.entity.Modelo;
import com.vicente.microserviciocoches.repository.ModeloRepository;
import com.vicente.microserviciocommons.service.CommonServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloServiceImpl extends CommonServiceImpl<Modelo, ModeloRepository> implements ModeloService {

    @Override
    public List<Modelo> findModeloByMarcaId(Long marcaId) {
        return repository.findModeloByMarcaId(marcaId);
    }
}
