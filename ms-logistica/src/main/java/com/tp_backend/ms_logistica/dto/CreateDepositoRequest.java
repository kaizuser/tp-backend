package com.tp_backend.ms_logistica.dto;

public record CreateDepositoRequest(
        String nombre,
        String ubicacion,
        String ciudad,
        String coordenadas,
        Double capacidad,
        Double costoXDia,
        String estado
) {}

