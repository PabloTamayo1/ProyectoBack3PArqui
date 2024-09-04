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
public class SolicitudCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSolicitud;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal montoSolicitado;

    @Column(nullable = false)
    private LocalDateTime fechaSolicitud;

    @Column(nullable = false)
    private String estado;

    @Column(precision = 5, scale = 2)
    private BigDecimal puntajeCrediticio;

    // constructor, getters and setters

    public SolicitudCredito() {
    }

    public SolicitudCredito(Long idSolicitud, Usuario usuario, BigDecimal montoSolicitado, LocalDateTime fechaSolicitud, String estado, BigDecimal puntajeCrediticio) {
        this.idSolicitud = idSolicitud;
        this.usuario = usuario;
        this.montoSolicitado = montoSolicitado;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
        this.puntajeCrediticio = puntajeCrediticio;
    }

    public Long getIdSolicitud() {
        return this.idSolicitud;
    }

    public void setIdSolicitud(Long idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public BigDecimal getMontoSolicitado() {
        return this.montoSolicitado;
    }

    public void setMontoSolicitado(BigDecimal montoSolicitado) {
        this.montoSolicitado = montoSolicitado;
    }

    public LocalDateTime getFechaSolicitud() {
        return this.fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getPuntajeCrediticio() {
        return this.puntajeCrediticio;
    }

    public void setPuntajeCrediticio(BigDecimal puntajeCrediticio) {
        this.puntajeCrediticio = puntajeCrediticio;
    }

    
}
