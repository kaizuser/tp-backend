package com.tp_backend.ms_logistica.dto;

public record DepositoDTO(
        Long id,
        String nombre,
        String ubicacion,
        String ciudad,
        String coordenadas,
        Double capacidad,
        Double costoXDia,
        String estado
) {}

