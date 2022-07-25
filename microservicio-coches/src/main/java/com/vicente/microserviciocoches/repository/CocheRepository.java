package com.vicente.microserviciocoches.repository;

import com.vicente.microserviciocoches.entity.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Long> {

    @Query("select coche from Coche coche join coche.modelo.marca marca join coche.modelo modelo where " +
            "(:marca is null or marca.nombre = :marca) and " +
            "(:modelo is null or modelo.nombre = :modelo) and " +
            "(:version is null or modelo.version = :version) and " +
            "(:motor is null or modelo.motor = :motor) and " +
            "(:cambio is null or modelo.cambio = :cambio) and " +
            "(:color is null or coche.color = :color) and" +
            "(:kmHasta is null or coche.kilometros <= :kmHasta) and" +
            "(:precioHasta is null or coche.precio <= :precioHasta)")
    public List<Coche> findByMarcaAndModeloAndKilometros(@Param("marca") String marca, @Param("modelo") String modelo, @Param("version") String version,
                                                         @Param("motor") String motor, @Param("cambio") String cambio, @Param("color") String color,
                                                         @Param("kmHasta") Integer kmHasta, @Param("precioHasta") Integer precioHasta);
}
