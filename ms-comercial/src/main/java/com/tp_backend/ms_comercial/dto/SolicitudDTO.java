package com.tp_backend.ms_comercial.dto;

import java.time.LocalDate;

public record SolicitudDTO(
        Long id,
        LocalDate fechaSolicitud,
        String origen,
        String destino,
        Double costoEstimado,
	Double costoFinal,
        String tiempoEstimado,
        String tiempoFinal,
        Long contenedorId,
        Long clienteId,
        String estado,
        Long rutaId
) {}

