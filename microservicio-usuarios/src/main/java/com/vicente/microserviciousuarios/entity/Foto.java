package com.vicente.microserviciousuarios.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "fotos")
public class Foto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    @JsonIgnore
    private byte[] foto;

    @ManyToOne
    @JoinColumn(name = "coche_id")
    @JsonIgnoreProperties("fotos")
    private Coche coche;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Integer getFotoHashCode() {
        return (this.foto != null)? this.foto.hashCode(): null;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(!(obj instanceof Foto a)) {
            return false;
        }
        return this.id != null && this.id.equals(a.getId());
    }
}
