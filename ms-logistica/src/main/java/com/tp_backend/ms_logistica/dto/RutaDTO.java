package com.tp_backend.ms_logistica.dto;

import java.time.LocalDate;

public record RutaDTO(
        Long id,
        String descripcion,
        LocalDate fechaInicio,
        LocalDate fechaFin,
        Integer cantidadTramos,
        Integer cantidadDepositos
) {}


