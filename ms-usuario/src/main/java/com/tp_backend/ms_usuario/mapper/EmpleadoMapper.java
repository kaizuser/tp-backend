package com.tp_backend.ms_usuario.mapper;

import org.springframework.stereotype.Component;

import com.tp_backend.ms_usuario.dto.EmpleadoDTO;
import com.tp_backend.ms_usuario.dto.EmpleadoCreateRequestDTO;
import com.tp_backend.ms_usuario.enums.EmpleadoRol;
import com.tp_backend.ms_usuario.model.Empleado;

@Component
public class EmpleadoMapper {

    public EmpleadoDTO toDTO(Empleado empleado) {
        if (empleado == null) return null;

        return new EmpleadoDTO(
                empleado.getIdEmpleado(),
                empleado.getDni(),
                empleado.getNombre(),
                empleado.getKeycloakUserId(),
                empleado.getRol() != null ? empleado.getRol().name() : null
        );
    }

    public Empleado toModel(EmpleadoCreateRequestDTO dto) {
        if (dto == null) return null;

        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(null);
        empleado.setDni(dto.dni());
        empleado.setNombre(dto.nombre());
        empleado.setKeycloakUserId(dto.keycloakUserId());
        empleado.setRol(dto.rol() != null ? EmpleadoRol.valueOf(dto.rol()) : null);

        return empleado;
    }

    public Empleado toModel(EmpleadoDTO dto) {
        if (dto == null) return null;

        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(dto.idEmpleado());
        empleado.setDni(dto.dni());
        empleado.setNombre(dto.nombre());
        empleado.setKeycloakUserId(dto.keycloakUserId());
        empleado.setRol(dto.rol() != null ? EmpleadoRol.valueOf(dto.rol()) : null);

        return empleado;
    }
}

