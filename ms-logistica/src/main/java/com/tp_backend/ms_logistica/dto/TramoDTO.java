package com.tp_backend.ms_logistica.dto;

import java.time.LocalDate;

public record TramoDTO(
        Long id,
        String origen,
        String destino,
        String tipo,
        Double distanciaKm,
        String estado,
        LocalDate fechaInicio,
        LocalDate fechaFin,
        Double costoEstimado,
        Double costoFinal,
        Long camionId,
        Long rutaId,
        Long depositoOrigenId,
        Long depositoDestinoId
) {}

