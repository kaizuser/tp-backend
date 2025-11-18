package com.tp_backend.ms_logistica.model;

import jakarta.persistence.*;
import lombok.*;
import com.tp_backend.ms_logistica.enums.EstadoEnum;

@Entity
@Table(name = "deposito")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deposito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String ubicacion;

    private String ciudad;

    private String coordenadas;

    private Double capacidad;

    @Column(name = "Costo_x_dia")
    private Double costoXDia;

    @Enumerated(EnumType.STRING)
    private EstadoEnum estado;
}

