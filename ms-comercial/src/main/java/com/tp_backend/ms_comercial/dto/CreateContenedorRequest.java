package com.tp_backend.ms_comercial.dto;

public record CreateContenedorRequest(
        Long codigo,
        Double capacidadTn,
        Double volumen,
        String estado,
        Long depositoId
) {}

