package com.tp_backend.ms_comercial.dto;

public record CreateContenedorRequest (
    Double capacidad_tn,
    String estado,
    Double volumen,
    Long idDeposito
    )
{}
