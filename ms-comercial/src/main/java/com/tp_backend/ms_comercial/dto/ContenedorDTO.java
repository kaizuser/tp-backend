package com.tp_backend.ms_comercial.dto;

public record ContenedorDTO(
        Long id,
        Long codigo,
        Double capacidadTn,
        Double volumen,
        String estado,
        Long depositoId
) {}


