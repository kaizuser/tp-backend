package com.tp_backend.ms_comercial.dto;

import java.time.LocalDate;

public record SolicitudDTO (
    Long id,
    LocalDate fecha_solicitud,
    String origen,
    String destino,
    Double costoEstimado,
    Double costoFinal,
    Double tiempoEstimado,
    Double tiempoFinal,
    String estado,
    Long clienteId,
    Long contenedorId,
    Long rutaId
) {
    
}
