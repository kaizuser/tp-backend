package com.tp_backend.ms_comercial.model;

import jakarta.persistence.*;
import lombok.*;
import com.tp_backend.ms_comercial.enums.*;


@Entity
@Table(name = "contenedor")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Contenedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo")
    private Long codigo;

    @Column(name = "capacidad_tn")
    private Double capacidadTn;

    @Column(name = "volumen")
    private Double volumen;

    @Enumerated(EnumType.STRING)
    private EstadoEnum estado;

    private long depositoId;
}
