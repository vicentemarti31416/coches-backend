package com.vicente.microserviciocoches.controller;

import com.vicente.microserviciocoches.entity.Modelo;
import com.vicente.microserviciocoches.service.ModeloService;
import com.vicente.microserviciocommons.controller.CommonController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modelo")
public class ModeloController extends CommonController<Modelo, ModeloService> {

    @GetMapping("/modelos-filter/{marcaId}")
    public ResponseEntity<?> getModelos(@PathVariable Long marcaId) {
        return ResponseEntity.ok().body(service.findModeloByMarcaId(marcaId));
    }

}
