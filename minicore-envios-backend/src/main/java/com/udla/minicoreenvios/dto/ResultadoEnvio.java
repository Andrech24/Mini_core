package com.udla.minicoreenvios.dto;

import java.math.BigDecimal;

public class ResultadoEnvio {
    private String repartidor;
    private int envios;
    private BigDecimal totalKg;
    private String zona;
    private BigDecimal tarifaKg;
    private BigDecimal costoTotal;

    public ResultadoEnvio(String repartidor, int envios, BigDecimal totalKg, String zona, BigDecimal tarifaKg, BigDecimal costoTotal) {
        this.repartidor = repartidor;
        this.envios = envios;
        this.totalKg = totalKg;
        this.zona = zona;
        this.tarifaKg = tarifaKg;
        this.costoTotal = costoTotal;
    }

    public String getRepartidor() {
        return repartidor;
    }

    public int getEnvios() {
        return envios;
    }

    public BigDecimal getTotalKg() {
        return totalKg;
    }

    public String getZona() {
        return zona;
    }

    public BigDecimal getTarifaKg() {
        return tarifaKg;
    }

    public BigDecimal getCostoTotal() {
        return costoTotal;
    }
}
