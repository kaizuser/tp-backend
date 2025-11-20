package com.tp_backend.ms_comercial.enums;

public enum EstadoEnum {

    BORRADOR("Borrador"),
    PROGRAMADA("Programada"),
    EN_TRANSITO("En transito"),
    ENTREGADA("Entregada"),
    
    EN_DEPOSITO("En deposito"),
    RETIRADO("Retirado"),
    EN_VIAJE("En viaje"),
    ENTREGADO("Entregado");


    private final String nombre;

    EstadoEnum(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
