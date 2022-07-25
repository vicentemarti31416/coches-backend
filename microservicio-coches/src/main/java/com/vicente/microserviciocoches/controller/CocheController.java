package com.vicente.microserviciocoches.controller;

import com.vicente.microserviciocoches.entity.Busqueda;
import com.vicente.microserviciocoches.entity.Coche;
import com.vicente.microserviciocoches.entity.Foto;
import com.vicente.microserviciocoches.service.CocheService;
import com.vicente.microserviciocommons.controller.CommonController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/coche")
public class CocheController extends CommonController<Coche, CocheService> {

    @PostMapping("/create-foto")
    public ResponseEntity<?> createFoto(@Validated Coche coche, BindingResult result, @RequestParam MultipartFile file) throws IOException {
        if (result.hasErrors()) return this.validar(result);
        Foto foto = new Foto();
        foto.setFoto(file.getBytes());
        if (!file.isEmpty()) coche.addFoto(foto);
        return super.crear(coche, result);
    }

    @PutMapping("/update/{idCoche}")
    public ResponseEntity<?> updateCoche(@Validated @RequestBody Coche coche, BindingResult result, @PathVariable Long idCoche) {
        if (result.hasErrors()) this.validar(result);
        Optional<Coche> optional = service.findById(idCoche);
        if (optional.isEmpty()) return ResponseEntity.notFound().build();
        Coche cocheDb = optional.get();
        cocheDb.setModelo(coche.getModelo());
        cocheDb.getFotos()
                .stream()
                .filter(foto -> !coche.getFotos().contains(foto))
                .forEach(cocheDb::removeFoto);
        cocheDb.setFotos(coche.getFotos());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cocheDb));
    }

    @PostMapping("/coches-filter")
    public ResponseEntity<?> getCoches(@Validated @RequestBody Busqueda busqueda, BindingResult result) {
        System.out.println("Busqueda = " + busqueda);
        return ResponseEntity.ok().body(service.findByMarcaAndModeloAndKilometros(busqueda.getMarca(), busqueda.getModelo(), busqueda.getVersion(),
                                        busqueda.getMotor(), busqueda.getCambio(), busqueda.getColor(), busqueda.getKmHasta(), busqueda.getPrecioHasta()));
    }

}
