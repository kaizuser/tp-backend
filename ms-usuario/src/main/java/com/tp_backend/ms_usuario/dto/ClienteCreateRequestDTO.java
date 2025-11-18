package com.tp_backend.ms_usuario.dto;

public record ClienteCreateRequestDTO (
     String dni,
     String nombre,
     String direccion,
     String email,
     String telefono,
     String keycloakUserId
){}

