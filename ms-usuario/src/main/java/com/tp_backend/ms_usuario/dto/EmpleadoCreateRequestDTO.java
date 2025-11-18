package com.tp_backend.ms_usuario.dto;

public record EmpleadoCreateRequestDTO (
     String dni,
     String nombre,
     String rol,
     String keycloakUserId
){}

