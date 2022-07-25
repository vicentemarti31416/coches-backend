package com.vicente.microserviciousuarios.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "marcas")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Marca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "marca",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = {"marca"}, allowSetters = true)
    private List<Modelo> modelos;

    public Marca() {
        modelos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public void addMarca(Modelo modelo) {
        this.modelos.add(modelo);
    }

    public void removeMarca(Modelo modelo) {
        this.modelos.remove(modelo);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(!(obj instanceof Marca a)) {
            return false;
        }
        return this.id != null && this.id.equals(a.getId());
    }
}
