package com.vicente.microserviciocoches.service;

import com.vicente.microserviciocoches.entity.Marca;
import com.vicente.microserviciocoches.repository.MarcaRepository;
import com.vicente.microserviciocommons.service.CommonServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MarcaServiceImpl extends CommonServiceImpl<Marca, MarcaRepository> implements MarcaService {
}
