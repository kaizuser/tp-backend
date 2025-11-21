package com.tp_backend.ms_comercial.controller;

import com.tp_backend.ms_comercial.dto.SolicitudDTO;
import com.tp_backend.ms_comercial.dto.CreateSolicitudRequest;
import com.tp_backend.ms_comercial.mapper.SolicitudMapper;
import com.tp_backend.ms_comercial.model.Solicitud;
import com.tp_backend.ms_comercial.service.SolicitudService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comercial/solicitud")
@RequiredArgsConstructor
public class SolicitudController {

    private final SolicitudService solicitudService;
    private final SolicitudMapper solicitudMapper;

    @PostMapping
    public ResponseEntity<SolicitudDTO> create(@RequestBody CreateSolicitudRequest dto) {
        try {
            Solicitud saved = solicitudService.save(dto);
            return ResponseEntity.ok(solicitudMapper.toDTO(saved));
        } catch (Exception e) {
	    e.printStackTrace(); // <---- ESTO

            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<SolicitudDTO>> getAll() {
        try {
            List<Solicitud> solicitudes = solicitudService.findAll();
            List<SolicitudDTO> dtos = solicitudes.stream()
                    .map(solicitudMapper::toDTO)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(dtos);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudDTO> getById(@PathVariable Long id) {
        try {
            Solicitud solicitud = solicitudService.findById(id);
            return ResponseEntity.ok(solicitudMapper.toDTO(solicitud));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitudDTO> update(@PathVariable Long id, @RequestBody SolicitudDTO dto) {
        try {
            Solicitud updated = solicitudService.update(id, dto);
            return ResponseEntity.ok(solicitudMapper.toDTO(updated));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            solicitudService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

