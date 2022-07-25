package com.vicente.microserviciocoches.repository;

import com.vicente.microserviciocoches.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    @Query("select modelo from Modelo modelo where marca.id = :marcaId")
    List<Modelo> findModeloByMarcaId(@Param("marcaId") Long marcaId);
}
