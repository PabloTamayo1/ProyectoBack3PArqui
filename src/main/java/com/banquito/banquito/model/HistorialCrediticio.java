package com.banquito.banquito.model;


import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class HistorialCrediticio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorial;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal puntajeBuro;

    @Column(precision = 15, scale = 2)
    private BigDecimal deudasActuales;

    @Column
    private String historialPagos;

    // constructor, getters and setters

    public HistorialCrediticio() {
    }

    public HistorialCrediticio(Long idHistorial, Usuario usuario, BigDecimal puntajeBuro, BigDecimal deudasActuales, String historialPagos) {
        this.idHistorial = idHistorial;
        this.usuario = usuario;
        this.puntajeBuro = puntajeBuro;
        this.deudasActuales = deudasActuales;
        this.historialPagos = historialPagos;
    }

    public Long getIdHistorial() {
        return this.idHistorial;
    }

    public void setIdHistorial(Long idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public BigDecimal getPuntajeBuro() {
        return this.puntajeBuro;
    }

    public void setPuntajeBuro(BigDecimal puntajeBuro) {
        this.puntajeBuro = puntajeBuro;
    }

    public BigDecimal getDeudasActuales() {
        return this.deudasActuales;
    }

    public void setDeudasActuales(BigDecimal deudasActuales) {
        this.deudasActuales = deudasActuales;
    }

    public String getHistorialPagos() {
        return this.historialPagos;
    }

    public void setHistorialPagos(String historialPagos) {
        this.historialPagos = historialPagos;
    }

    
}
