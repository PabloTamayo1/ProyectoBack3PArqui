package com.banquito.banquito.model;


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
public class LogActividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLog;

    @Column(nullable = false)
    private LocalDateTime fechaActividad;

    @Column(nullable = false)
    private String tipoActividad;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "analista_id")
    private AnalistaCredito analista;

    @Column(nullable = false)
    private String descripcion;

    // constructor, getters and setters

    public LogActividad() {
    }

    public LogActividad(Long idLog, LocalDateTime fechaActividad, String tipoActividad, Usuario usuario, AnalistaCredito analista, String descripcion) {
        this.idLog = idLog;
        this.fechaActividad = fechaActividad;
        this.tipoActividad = tipoActividad;
        this.usuario = usuario;
        this.analista = analista;
        this.descripcion = descripcion;
    }

    public Long getIdLog() {
        return this.idLog;
    }

    public void setIdLog(Long idLog) {
        this.idLog = idLog;
    }

    public LocalDateTime getFechaActividad() {
        return this.fechaActividad;
    }

    public void setFechaActividad(LocalDateTime fechaActividad) {
        this.fechaActividad = fechaActividad;
    }

    public String getTipoActividad() {
        return this.tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public AnalistaCredito getAnalista() {
        return this.analista;
    }

    public void setAnalista(AnalistaCredito analista) {
        this.analista = analista;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
