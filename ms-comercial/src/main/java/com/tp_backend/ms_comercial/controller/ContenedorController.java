package com.tp_backend.ms_comercial.controller;

import com.tp_backend.ms_comercial.dto.ContenedorDTO;
import com.tp_backend.ms_comercial.dto.CreateContenedorRequest;
import com.tp_backend.ms_comercial.mapper.ContenedorMapper;
import com.tp_backend.ms_comercial.model.Contenedor;
import com.tp_backend.ms_comercial.service.ContenedorService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comercial/contenedor")
@RequiredArgsConstructor
public class ContenedorController {

    private final ContenedorService contenedorService;
    private final ContenedorMapper contenedorMapper;

    @PostMapping
    public ResponseEntity<ContenedorDTO> create(@RequestBody CreateContenedorRequest dto) {
        try {
            Contenedor contenedor = contenedorMapper.toModel(dto);
            Contenedor saved = contenedorService.save(contenedor);
            return ResponseEntity.ok(contenedorMapper.toDTO(saved));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ContenedorDTO>> getAll() {
        try {
            List<Contenedor> contenedores = contenedorService.findAll();
            List<ContenedorDTO> dtos = contenedores.stream()
                    .map(contenedorMapper::toDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContenedorDTO> getById(@PathVariable Long id) {
        try {
            Contenedor contenedor = contenedorService.findById(id);
            return ResponseEntity.ok(contenedorMapper.toDTO(contenedor));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContenedorDTO> update(@PathVariable Long id, @RequestBody ContenedorDTO dto) {
        try {
            Contenedor contenedor = contenedorMapper.toModel(dto);
            Contenedor updated = contenedorService.update(id, contenedor);
            return ResponseEntity.ok(contenedorMapper.toDTO(updated));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            contenedorService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

