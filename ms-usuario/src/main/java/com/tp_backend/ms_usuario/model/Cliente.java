package com.tp_backend.ms_usuario.model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String dni;
    
    @NotBlank
    @Column(nullable = false)
    private String nombre;

    private String direccion;
    private String telefono;
    
    @Column(unique = true)
    private String email;

    // UUID de Keycloak
    @Column(unique = true)
    private String keycloakUserId;
}

