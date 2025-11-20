package com.tp_backend.ms_comercial.dto;

import java.time.LocalDate;

public record CreateSolicitudRequest (
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
    )
{}
