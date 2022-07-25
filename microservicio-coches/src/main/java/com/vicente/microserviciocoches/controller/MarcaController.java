package com.vicente.microserviciocoches.controller;

import com.vicente.microserviciocoches.entity.Marca;
import com.vicente.microserviciocoches.service.MarcaService;
import com.vicente.microserviciocommons.controller.CommonController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marca")
public class MarcaController extends CommonController<Marca, MarcaService> {
}
