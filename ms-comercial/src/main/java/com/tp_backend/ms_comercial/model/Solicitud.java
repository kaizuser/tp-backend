package com.tp_backend.ms_comercial.model;

import jakarta.persistence.*;
import lombok.*;
import com.tp_backend.ms_comercial.enums.*;

@Entity
@Table(name = "camion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSolicitud;

    @Column(name = "fecha_solicitud")
    private String fechaSolicitud;

    @Column(name = "origen")
    private String origen;

    @Column(name = "destino")
    private String destino;

    @Column(name = "costo_estimado")
    private Double costoEstimado;

    @Column(name = "tiempo_estimado")
    private String tiempoEstimado;

    @Column(name = "tiempo_final")
    private String tiempoFinal;

    @Enumerated(EnumType.STRING)
    private Contenedor contenedor;

    private Long clienteId;

    @Enumerated(EnumType.STRING)
    private EstadoEnum estado;

    private Long rutaId;
    


    
}
