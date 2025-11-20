package com.tp_backend.ms_comercial.dto;
//hay nombres cuando son fk
//que no son iguales a los dtos/models pero no sabemos si es necesario
public record ContenedorDTO (
    Long codigo,
    Double capacidad_tn,
    String estado,
    Double volumen,
    Long idDeposito
    

    )
{}
