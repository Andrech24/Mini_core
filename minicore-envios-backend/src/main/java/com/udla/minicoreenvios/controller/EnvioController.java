package com.udla.minicoreenvios.controller;

import com.udla.minicoreenvios.dto.ResultadoEnvio;
import com.udla.minicoreenvios.service.EnvioService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EnvioController {
    private final EnvioService envioService;

    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @GetMapping("/api/envios/costos")
    public List<ResultadoEnvio> listarCostos(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
        return envioService.calcularCostos(fechaInicio, fechaFin);
    }
}