package com.udla.minicoreenvios.model;

import java.math.BigDecimal;

public class Zona {
    private int idZona;
    private String nombreZona;
    private BigDecimal tarifaPorKg;

    public Zona(int idZona, String nombreZona, BigDecimal tarifaPorKg) {
        this.idZona = idZona;
        this.nombreZona = nombreZona;
        this.tarifaPorKg = tarifaPorKg;
    }

    public int getIdZona() {
        return idZona;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public BigDecimal getTarifaPorKg() {
        return tarifaPorKg;
    }
}
