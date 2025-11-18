package com.tp_backend.ms_usuario.service.impl;

import com.tp_backend.ms_usuario.enums.EmpleadoRol;
import com.tp_backend.ms_usuario.model.Empleado;
import com.tp_backend.ms_usuario.repository.EmpleadoRepository;
import com.tp_backend.ms_usuario.service.EmpleadoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Override
    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado update(Long id, Empleado empleado) {
        Empleado existing = empleadoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado"));

        existing.setDni(empleado.getDni());
        existing.setNombre(empleado.getNombre());
        existing.setRol(empleado.getRol());
        existing.setKeycloakUserId(empleado.getKeycloakUserId());

        return empleadoRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        empleadoRepository.deleteById(id);
    }

    @Override
    public Empleado findById(Long id) {
        return empleadoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado"));
    }

    @Override
    public Empleado findByKeycloakUserId(String keycloakUserId) {
        return empleadoRepository.findByKeycloakUserId(keycloakUserId)
                .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado"));
    }

    @Override
    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }
}

