package com.tp_backend.ms_logistica.enums;

public enum EstadoEnum {
    CERRADO("Cerrado"),
    ACTIVO("Activo"),
    EN_CURSO("En curso");

    private final String nombre;

    EstadoEnum(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
