package com.vicente.microserviciousuarios.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "coches")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Coche implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "modelo_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private Modelo modelo;

    @JsonIgnoreProperties(value = {"coche"})
    @OneToMany(mappedBy = "coche", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Foto> fotos;

    private Long kilometros;

    public Coche() {
        fotos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public void addFotos(List<Foto> fotos) {
        this.fotos.clear();
        fotos.forEach(this::addFoto);
    }

    public void addFoto(Foto foto) {
        this.fotos.add(foto);
    }

    public void removeFoto(Foto foto) {
        this.fotos.remove(foto);
    }

    public Long getKilometros() {
        return kilometros;
    }

    public void setKilometros(Long kilometros) {
        this.kilometros = kilometros;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(!(obj instanceof Coche a)) {
            return false;
        }
        return this.id != null && this.id.equals(a.getId());
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", modelo=" + modelo +
                ", fotos=" + fotos +
                ", kilometros=" + kilometros +
                '}';
    }
}
