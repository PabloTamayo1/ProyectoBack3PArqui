package com.banquito.banquito.model;


import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, unique = true, length = 100)
    private String correoElectronico;

    @Column(nullable = false, unique = true, length = 50)
    private String numeroIdentificacion;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal ingresosMensuales;

    @Column(nullable = false)
    private String direccion;

    // constructor, getters and setters

    public Usuario() {
    }

    public Usuario(Long idUsuario, String nombre, String correoElectronico, String numeroIdentificacion, BigDecimal ingresosMensuales, String direccion) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.numeroIdentificacion = numeroIdentificacion;
        this.ingresosMensuales = ingresosMensuales;
        this.direccion = direccion;
    }

    public Long getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumeroIdentificacion() {
        return this.numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public BigDecimal getIngresosMensuales() {
        return this.ingresosMensuales;
    }

    public void setIngresosMensuales(BigDecimal ingresosMensuales) {
        this.ingresosMensuales = ingresosMensuales;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
