package com.tp_backend.ms_logistica.model;

import jakarta.persistence.*;
import lombok.*;
import com.tp_backend.ms_logistica.enums.EstadoEnum;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tramo")
public class Tramo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origen;
    private String destino;
    private String tipo;

    @Column(name = "distancia_km")
    private Double distanciaKm;

    @Enumerated(EnumType.STRING)
    private EstadoEnum estado;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "costo_estimado")
    private Double costoEstimado;

    @Column(name = "costo_final")
    private Double costoFinal;

    // ------- RELACIONES --------

    // id_camion
    @ManyToOne
    @JoinColumn(name = "id_camion")
    private Camion camion;

    // id_ruta
    @ManyToOne
    @JoinColumn(name = "id_ruta")
    private Ruta ruta;

    // id_deposito_origen
    @ManyToOne
    @JoinColumn(name = "id_deposito_origen")
    private Deposito depositoOrigen;

    // id_deposito_destino
    @ManyToOne
    @JoinColumn(name = "id_deposito_destino")
    private Deposito depositoDestino;
}

