package com.tp_backend.ms_logistica.controller;

import com.tp_backend.ms_logistica.dto.RutaDTO;
import com.tp_backend.ms_logistica.dto.CreateRutaRequest;
import com.tp_backend.ms_logistica.mapper.RutaMapper;
import com.tp_backend.ms_logistica.model.Ruta;
import com.tp_backend.ms_logistica.service.RutaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;

import java.util.List;

@RestController
@RequestMapping("/logistica/ruta")
@RequiredArgsConstructor
public class RutaController {

    private final RutaService rutaService;
    private final RutaMapper rutaMapper;


    @PostMapping
    public ResponseEntity<RutaDTO> create(@RequestBody CreateRutaRequest dto) {
        try {
            Ruta ruta = rutaMapper.toModel(dto);
            Ruta saved = rutaService.save(ruta);
            return ResponseEntity.ok(rutaMapper.toDTO(saved));

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

    @GetMapping
    public ResponseEntity<List<RutaDTO>> getAll() {
        try {
            List<Ruta> rutas = rutaService.findAll();
            List<RutaDTO> dtos = rutas.stream()
                                             .map(rutaMapper::toDTO)
                                             .collect(Collectors.toList());

            return ResponseEntity.ok(dtos);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RutaDTO> getById(@PathVariable Long id) {
        try {
            Ruta ruta = rutaService.findById(id);
            return ResponseEntity.ok(rutaMapper.toDTO(ruta));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RutaDTO> update(@PathVariable Long id, @RequestBody RutaDTO dto) {
        try {
            Ruta ruta = rutaMapper.toModel(dto);
            Ruta updated = rutaService.update(id, ruta);

            return ResponseEntity.ok(rutaMapper.toDTO(updated));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            rutaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
