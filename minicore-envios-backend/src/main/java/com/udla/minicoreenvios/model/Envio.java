package com.udla.minicoreenvios.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Envio {
    private int idEnvio;
    private int idRepartidor;
    private int idZona;
    private BigDecimal pesoKg;
    private LocalDate fechaEnvio;

    public Envio(int idEnvio, int idRepartidor, int idZona, BigDecimal pesoKg, LocalDate fechaEnvio) {
        this.idEnvio = idEnvio;
        this.idRepartidor = idRepartidor;
        this.idZona = idZona;
        this.pesoKg = pesoKg;
        this.fechaEnvio = fechaEnvio;
    }

    public int getIdEnvio() {
        return idEnvio;
    }

    public int getIdRepartidor() {
        return idRepartidor;
    }

    public int getIdZona() {
        return idZona;
    }

    public BigDecimal getPesoKg() {
        return pesoKg;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }
}
