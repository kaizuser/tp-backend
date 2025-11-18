package com.tp_backend.ms_logistica.controller;

import com.tp_backend.ms_logistica.dto.CamionDTO;
import com.tp_backend.ms_logistica.dto.CreateCamionRequest;
import com.tp_backend.ms_logistica.mapper.CamionMapper;
import com.tp_backend.ms_logistica.model.Camion;
import com.tp_backend.ms_logistica.service.CamionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;


import java.util.List;

@RestController
@RequestMapping("/logistica/camiones")
@RequiredArgsConstructor
public class CamionController {

    private final CamionService camionService;
    private final CamionMapper camionMapper;


    @PostMapping
    public ResponseEntity<CamionDTO> create(@RequestBody CreateCamionRequest dto) {
        try {
            Camion camion = camionMapper.toModel(dto);
            Camion saved = camionService.save(camion);
            return ResponseEntity.ok(camionMapper.toDTO(saved));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

    @GetMapping
    public ResponseEntity<List<CamionDTO>> getAll() {
        try {
            List<Camion> camiones = camionService.findAll();
            List<CamionDTO> dtos = camiones.stream()
                                           .map(camionMapper::toDTO)
                                           .collect(Collectors.toList());

            return ResponseEntity.ok(dtos);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CamionDTO> getById(@PathVariable Long id) {
        try {
            Camion camion = camionService.findById(id);
            return ResponseEntity.ok(camionMapper.toDTO(camion));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CamionDTO> update(@PathVariable Long id, @RequestBody CamionDTO dto) {
        try {
            Camion camion = camionMapper.toModel(dto);
            Camion updated = camionService.update(id, camion);

            return ResponseEntity.ok(camionMapper.toDTO(updated));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            camionService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

