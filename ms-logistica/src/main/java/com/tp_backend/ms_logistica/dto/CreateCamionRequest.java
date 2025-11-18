package com.tp_backend.ms_logistica.dto;

public record CreateCamionRequest(
        String patente,
        String modeloNombreTransportista,
        String telefonoTransportista,
        Double volumen,
        Double peso,
        String estado,
        Double costos,
        Double costoXKilometro,
        Double costoXCombustible,
        Long empleadoId
) {}

