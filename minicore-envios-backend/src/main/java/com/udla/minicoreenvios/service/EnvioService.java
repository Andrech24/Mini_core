package com.udla.minicoreenvios.service;

import com.udla.minicoreenvios.dto.ResultadoEnvio;
import com.udla.minicoreenvios.model.Envio;
import com.udla.minicoreenvios.model.Repartidor;
import com.udla.minicoreenvios.model.Zona;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class EnvioService {
    private final List<Repartidor> repartidores = List.of(
            new Repartidor(1, "Andres Molina", "andres@correo.com"),
            new Repartidor(2, "Camila Torres", "camila@correo.com"),
            new Repartidor(3, "Luis Vera", "luis@correo.com")
    );

    private final List<Zona> zonas = List.of(
            new Zona(1, "Norte", new BigDecimal("1.50")),
            new Zona(2, "Sur", new BigDecimal("2.00")),
            new Zona(3, "Centro", new BigDecimal("1.25"))
    );

    private final List<Envio> envios = List.of(
            new Envio(1, 1, 1, new BigDecimal("8"), LocalDate.of(2025, 5, 2)),
            new Envio(2, 1, 1, new BigDecimal("7"), LocalDate.of(2025, 5, 8)),
            new Envio(3, 1, 3, new BigDecimal("4"), LocalDate.of(2025, 5, 15)),
            new Envio(4, 1, 1, new BigDecimal("6"), LocalDate.of(2025, 5, 20)),
            new Envio(5, 2, 2, new BigDecimal("5"), LocalDate.of(2025, 5, 6)),
            new Envio(6, 2, 2, new BigDecimal("9"), LocalDate.of(2025, 5, 18)),
            new Envio(7, 2, 3, new BigDecimal("4"), LocalDate.of(2025, 5, 26)),
            new Envio(8, 3, 1, new BigDecimal("10"), LocalDate.of(2025, 4, 12)),
            new Envio(9, 3, 2, new BigDecimal("3"), LocalDate.of(2025, 6, 4))
    );

    public List<ResultadoEnvio> calcularCostos(LocalDate fechaInicio, LocalDate fechaFin) {
        List<ResultadoEnvio> resultados = new ArrayList<>();

        for (Repartidor repartidor : repartidores) {
            for (Zona zona : zonas) {
                int cantidad = 0;
                BigDecimal totalKg = BigDecimal.ZERO;
                BigDecimal costoTotal = BigDecimal.ZERO;

                for (Envio envio : envios) {
                    boolean esRepartidor = envio.getIdRepartidor() == repartidor.getIdRepartidor();
                    boolean esZona = envio.getIdZona() == zona.getIdZona();
                    boolean estaEnFecha = !envio.getFechaEnvio().isBefore(fechaInicio)
                            && !envio.getFechaEnvio().isAfter(fechaFin);

                    if (esRepartidor && esZona && estaEnFecha) {
                        cantidad++;
                        totalKg = totalKg.add(envio.getPesoKg());
                        costoTotal = costoTotal.add(envio.getPesoKg().multiply(zona.getTarifaPorKg()));
                    }
                }

                if (cantidad > 0) {
                    resultados.add(new ResultadoEnvio(
                            repartidor.getNombre(),
                            cantidad,
                            totalKg,
                            zona.getNombreZona(),
                            zona.getTarifaPorKg(),
                            costoTotal
                    ));
                }
            }
        }

        resultados.sort(Comparator.comparing(ResultadoEnvio::getRepartidor).thenComparing(ResultadoEnvio::getZona));
        return resultados;
    }
}
