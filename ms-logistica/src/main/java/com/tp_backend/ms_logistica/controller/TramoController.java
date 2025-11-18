package com.tp_backend.ms_logistica.controller;

import com.tp_backend.ms_logistica.dto.TramoDTO;
import com.tp_backend.ms_logistica.dto.CreateTramoRequest;
import com.tp_backend.ms_logistica.mapper.TramoMapper;
import com.tp_backend.ms_logistica.model.Tramo;
import com.tp_backend.ms_logistica.model.Ruta;
import com.tp_backend.ms_logistica.model.Camion;
import com.tp_backend.ms_logistica.model.Deposito;
import com.tp_backend.ms_logistica.enums.EstadoEnum;
import com.tp_backend.ms_logistica.service.TramoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;

import java.util.List;

@RestController
@RequestMapping("/tramos")
@RequiredArgsConstructor
public class TramoController {

    private final TramoService tramoService;
    private final TramoMapper tramoMapper;


    @PostMapping
    public ResponseEntity<TramoDTO> create(@RequestBody CreateTramoRequest dto) {
        try {
            Tramo saved = tramoService.save(dto); 
            return ResponseEntity.ok(tramoMapper.toDTO(saved));

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

    @GetMapping
    public ResponseEntity<List<TramoDTO>> getAll() {
        try {
            List<Tramo> tramos = tramoService.findAll();
            List<TramoDTO> dtos = tramos.stream()
                                             .map(tramoMapper::toDTO)
                                             .collect(Collectors.toList());

            return ResponseEntity.ok(dtos);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TramoDTO> getById(@PathVariable Long id) {
        try {
            Tramo tramo = tramoService.findById(id);
            return ResponseEntity.ok(tramoMapper.toDTO(tramo));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TramoDTO> update(@PathVariable Long id, @RequestBody TramoDTO dto) {
        try {
            Tramo updated = tramoService.update(id, dto); 
            return ResponseEntity.ok(tramoMapper.toDTO(updated));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            tramoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
