package com.tp_backend.ms_usuario.controller;

import com.tp_backend.ms_usuario.dto.EmpleadoDTO;
import com.tp_backend.ms_usuario.dto.EmpleadoCreateRequestDTO;
import com.tp_backend.ms_usuario.mapper.EmpleadoMapper;
import com.tp_backend.ms_usuario.model.Empleado;
import com.tp_backend.ms_usuario.service.EmpleadoService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario/empleado")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService empleadoService;
    private final EmpleadoMapper empleadoMapper;

    @PostMapping
    public ResponseEntity<EmpleadoDTO> create(@RequestBody EmpleadoCreateRequestDTO dto) {
        try {
            Empleado empleado = empleadoMapper.toModel(dto);
            Empleado saved = empleadoService.save(empleado);
            return ResponseEntity.ok(empleadoMapper.toDTO(saved));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> getAll() {
        try {
            List<Empleado> empleados = empleadoService.findAll();
            List<EmpleadoDTO> dtos = empleados.stream()
                    .map(empleadoMapper::toDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> getById(@PathVariable Long id) {
        try {
            Empleado empleado = empleadoService.findById(id);
            return ResponseEntity.ok(empleadoMapper.toDTO(empleado));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> update(@PathVariable Long id, @RequestBody EmpleadoDTO dto) {
        try {
            Empleado empleado = empleadoMapper.toModel(dto);
            Empleado updated = empleadoService.update(id, empleado);
            return ResponseEntity.ok(empleadoMapper.toDTO(updated));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            empleadoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

