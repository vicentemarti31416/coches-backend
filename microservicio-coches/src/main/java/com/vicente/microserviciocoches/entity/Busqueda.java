package com.vicente.microserviciocoches.entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
public class Busqueda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private String version;
    private String motor;
    private String cambio;
    private String color;
    @Nullable
    private Integer kmHasta;
    @Nullable
    private Integer precioHasta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Nullable
    public Integer getKmHasta() {
        return kmHasta;
    }

    public void setKmHasta(Integer kmHasta) {
        this.kmHasta = kmHasta;
    }

    @Nullable
    public Integer getPrecioHasta() {
        return precioHasta;
    }

    public void setPrecioHasta(@Nullable Integer precioHasta) {
        this.precioHasta = precioHasta;
    }

    @Override
    public String toString() {
        return "Busqueda{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", version='" + version + '\'' +
                ", motor='" + motor + '\'' +
                ", cambio='" + cambio + '\'' +
                ", color='" + color + '\'' +
                ", kmHasta=" + kmHasta +
                ", precioHasta=" + precioHasta +
                '}';
    }
}
