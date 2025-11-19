package com.tp_backend.ms_comercial.model;


import jakarta.persistence.*;
import lombok.*;
import com.tp_backend.ms_comercial.enums.*;
import com.tp_backend.ms_comercial.model.Contenedor;


@Entity
@Table(name = "tarifa")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tarifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarifa;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "monto")
    private Double monto;

    @Column(name = "costo_por_combustible")
    private Double costo_por_combustible;

    @Column(name = "costo_por_kilometro")
    private Double costo_por_kilometro;

    private long camionId;
        
    private long depositoId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contenedor_id", unique = true, nullable = false)
    private Contenedor contenedor;

    private long rutaId;
    
}
