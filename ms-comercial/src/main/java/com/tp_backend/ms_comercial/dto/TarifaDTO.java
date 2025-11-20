package com.tp_backend.ms_comercial.dto;

public record TarifaDTO(
        Long id,
        String tipo,
        Double monto,
        Double costo_por_combustible,
        Double costo_por_kilometro,
        Long camionId,
        Long depositoId,
        Long contenedorId,
        Long rutaId
) {}


