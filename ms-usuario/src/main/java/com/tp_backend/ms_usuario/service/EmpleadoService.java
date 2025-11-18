package com.tp_backend.ms_usuario.service;

import com.tp_backend.ms_usuario.model.Empleado;

import java.util.List;

public interface EmpleadoService {

    Empleado save(Empleado empleado);

    Empleado update(Long id, Empleado empleado);

    void delete(Long id);

    Empleado findById(Long id);

    Empleado findByKeycloakUserId(String keycloakUserId);

    List<Empleado> findAll();
}

