package com.tp_backend.ms_usuario.dto;

public record EmpleadoDTO (
     Long idEmpleado,
     String dni,
     String nombre,
     String rol,
     String keycloakUserId
){}

