package com.vicente.microserviciousuarios.controller;

import com.vicente.microserviciocommons.controller.CommonController;
import com.vicente.microserviciousuarios.entity.Coche;
import com.vicente.microserviciousuarios.entity.Usuario;
import com.vicente.microserviciousuarios.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UsuarioController extends CommonController<Usuario, UsuarioService> {

    @PutMapping("/update-usuario/{idUsuario}")
    public ResponseEntity<?> updateUsuario(@Validated @RequestBody Usuario usuario, BindingResult result, @PathVariable Long idUsuario) {
        if(result.hasErrors()) return this.validar(result);
        Optional<Usuario> optional = this.service.findById(idUsuario);
        if (optional.isEmpty()) return ResponseEntity.notFound().build();
        Usuario user = optional.get();
        user.setNombre(usuario.getNombre());
        user.setApellidos(usuario.getApellidos());
        user.setTelefono(usuario.getTelefono());
        user.setEmail(usuario.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuario));
    }

    @PutMapping("/add-coche/{idUsuario}")
    public ResponseEntity<?> addCoche(@Validated @RequestBody Coche coche, BindingResult result, @PathVariable Long idUsuario) {
        if(result.hasErrors()) return this.validar(result);
        Optional<Usuario> optional = this.service.findById(idUsuario);
        if (optional.isEmpty()) ResponseEntity.notFound().build();
        @SuppressWarnings("OptionalGetWithoutIsPresent") Usuario usuarioDb = optional.get();
        usuarioDb.addCoche(coche);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(usuarioDb));
    }

    @PutMapping("/remove-coche/{idUsuario}")
    public ResponseEntity<?> removeCoche(@Validated @RequestBody Coche coche, BindingResult result, @PathVariable Long idUsuario) {
        if(result.hasErrors()) return this.validar(result);
        Optional<Usuario> optional = this.service.findById(idUsuario);
        if (optional.isEmpty()) ResponseEntity.notFound().build();
        @SuppressWarnings("OptionalGetWithoutIsPresent") Usuario usuarioDb = optional.get();
        usuarioDb.removeCoche(coche);
        return ResponseEntity.status(HttpStatus.OK).body(this.service.save(usuarioDb));
    }

}

