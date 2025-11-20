package com.tp_backend.ms_comercial.controller;

import com.tp_backend.ms_comercial.dto.TarifaDTO;
import com.tp_backend.ms_comercial.dto.CreateTarifaRequest;
import com.tp_backend.ms_comercial.mapper.TarifaMapper;
import com.tp_backend.ms_comercial.model.Tarifa;
import com.tp_backend.ms_comercial.service.TarifaService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comercial/tarifa")
@RequiredArgsConstructor
public class TarifaController {

    private final TarifaService tarifaService;
    private final TarifaMapper tarifaMapper;

    @PostMapping
    public ResponseEntity<TarifaDTO> create(@RequestBody CreateTarifaRequest dto) {
        try {
            Tarifa saved = tarifaService.save(dto);
            return ResponseEntity.ok(tarifaMapper.toDTO(saved));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<TarifaDTO>> getAll() {
        try {
            List<Tarifa> tarifas = tarifaService.findAll();
            List<TarifaDTO> dtos = tarifas.stream()
                    .map(tarifaMapper::toDTO)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(dtos);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarifaDTO> getById(@PathVariable Long id) {
        try {
            Tarifa tarifa = tarifaService.findById(id);
            return ResponseEntity.ok(tarifaMapper.toDTO(tarifa));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarifaDTO> update(@PathVariable Long id, @RequestBody TarifaDTO dto) {
        try {
            Tarifa updated = tarifaService.update(id, dto);
            return ResponseEntity.ok(tarifaMapper.toDTO(updated));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            tarifaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

