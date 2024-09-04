package com.banquito.banquito.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;

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
public class TransaccionInterna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaccion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private String tipoTransaccion;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal monto;

    @Column(nullable = false)
    private LocalDateTime fechaTransaccion;

    // constructor, getters and setters

    public TransaccionInterna() {
    }

    public TransaccionInterna(Long idTransaccion, Usuario usuario, String tipoTransaccion, BigDecimal monto, LocalDateTime fechaTransaccion) {
        this.idTransaccion = idTransaccion;
        this.usuario = usuario;
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
        this.fechaTransaccion = fechaTransaccion;
    }

    public Long getIdTransaccion() {
        return this.idTransaccion;
    }

    public void setIdTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTipoTransaccion() {
        return this.tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public BigDecimal getMonto() {
        return this.monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaTransaccion() {
        return this.fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDateTime fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    
}

