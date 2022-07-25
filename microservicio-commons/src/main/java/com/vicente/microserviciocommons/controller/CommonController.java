package com.vicente.microserviciocommons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.vicente.microserviciocommons.service.CommonService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;


public class CommonController<E, S extends CommonService<E>> {

    @Autowired
    protected S service;

    @GetMapping("/")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id) {
        Optional<E> optional = service.findById(id);
        if (optional.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(optional.get());
    }

    @PostMapping
    public ResponseEntity<?> crear(@Validated @RequestBody E entity, BindingResult result) {
        if (result.hasErrors()) return this.validar(result);
        E e = service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(e);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        this.service.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    protected ResponseEntity<?> validar(BindingResult result) {
        Map<String, Object> errores = new HashMap<>();
        result.getFieldErrors().forEach( error ->
                errores.put(error.getField(), "El campo ".concat(error.getField().concat(" ").concat(Objects.requireNonNull(error.getDefaultMessage()))))
        );
        return ResponseEntity.badRequest().body(errores);
    }
}
