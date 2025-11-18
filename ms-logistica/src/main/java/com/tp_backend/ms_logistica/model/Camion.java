package com.tp_backend.ms_logistica.model;

import jakarta.persistence.*;
import lombok.*;
import com.tp_backend.ms_logistica.enums.EstadoEnum;

@Entity
@Table(name = "camion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Camion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patente;

    @Column(name = "modelo_nombre_transportista")
    private String modeloNombreTransportista;

    @Column(name = "telefono_transportista")
    private String telefonoTransportista;

    private Double volumen;
    private Double peso;

    @Enumerated(EnumType.STRING)
    private EstadoEnum estado;

    private Double costos;

    @Column(name = "Costo_x_kilometro")
    private Double costoXKilometro;

    @Column(name = "Costo_x_combustible")
    private Double costoXCombustible;

    private Long empleadoId;

}

