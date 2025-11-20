package com.tp_backend.ms_comercial.model;

import jakarta.persistence.*;
import lombok.*;
import com.tp_backend.ms_comercial.enums.*;
import com.tp_backend.ms_comercial.model.Contenedor;
import java.time.LocalDate;


@Entity
@Table(name = "solicitud")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_solicitud")
    private LocalDate fechaSolicitud;

    @Column(name = "origen")
    private String origen;

    @Column(name = "destino")
    private String destino;

    @Column(name = "costo_estimado")
    private Double costoEstimado;

    @Column(name = "costo_final")
    private Double costoFinal;

    @Column(name = "tiempo_estimado")
    private String tiempoEstimado;

    @Column(name = "tiempo_final")
    private String tiempoFinal;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contenedor_id", unique = true, nullable = false)
    private Contenedor contenedor;

    @Column(name = "cliente_id")
    private Long clienteId;

    @Enumerated(EnumType.STRING)
    private EstadoEnum estado;

    @Column(name = "ruta_id")
    private Long rutaId;
    
}
