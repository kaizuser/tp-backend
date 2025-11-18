package com.tp_backend.ms_usuario.model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
import com.tp_backend.ms_usuario.enums.EmpleadoRol;

@Entity
@Table(name = "empleado")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpleado;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String dni;

    @NotBlank
    @Column(nullable = false)
    private String nombre;

    // UUID del usuario en Keycloak
    @Column(unique = true)
    private String keycloakUserId;

    @Enumerated(EnumType.STRING)
    private EmpleadoRol rol;

}

