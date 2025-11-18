package com.tp_backend.ms_usuario.enums;

public enum EmpleadoRol {
    OPERADOR("Operador"),
    TRANSPORTISTA("Transportista");

    private final String nombre;

    EmpleadoRol(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
