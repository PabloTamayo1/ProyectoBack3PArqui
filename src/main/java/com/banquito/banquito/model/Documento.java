package com.banquito.banquito.model;


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
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocumento;

    @Column(nullable = false)
    private String tipoDocumento;

    @Column(nullable = false)
    private String urlDocumento;

    @ManyToOne
    @JoinColumn(name = "solicitud_id", nullable = false)
    private SolicitudCredito solicitudCredito;

    // constructor, getters and setters

    public Documento() {
    }

    public Documento(Long idDocumento, String tipoDocumento, String urlDocumento, SolicitudCredito solicitudCredito) {
        this.idDocumento = idDocumento;
        this.tipoDocumento = tipoDocumento;
        this.urlDocumento = urlDocumento;
        this.solicitudCredito = solicitudCredito;
    }

    public Long getIdDocumento() {
        return this.idDocumento;
    }

    public void setIdDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getUrlDocumento() {
        return this.urlDocumento;
    }

    public void setUrlDocumento(String urlDocumento) {
        this.urlDocumento = urlDocumento;
    }

    public SolicitudCredito getSolicitudCredito() {
        return this.solicitudCredito;
    }

    public void setSolicitudCredito(SolicitudCredito solicitudCredito) {
        this.solicitudCredito = solicitudCredito;
    }

    
}
