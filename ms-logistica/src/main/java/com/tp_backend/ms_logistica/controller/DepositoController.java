package com.tp_backend.ms_logistica.controller;

import com.tp_backend.ms_logistica.dto.DepositoDTO;
import com.tp_backend.ms_logistica.dto.CreateDepositoRequest;
import com.tp_backend.ms_logistica.mapper.DepositoMapper;
import com.tp_backend.ms_logistica.model.Deposito;
import com.tp_backend.ms_logistica.service.DepositoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;

import java.util.List;

@RestController
@RequestMapping("/logistica/deposito")
@RequiredArgsConstructor
public class DepositoController {

    private final DepositoService depositoService;
    private final DepositoMapper depositoMapper;


    @PostMapping
    public ResponseEntity<DepositoDTO> create(@RequestBody CreateDepositoRequest dto) {
        try {
            Deposito deposito = depositoMapper.toModel(dto);
            Deposito saved = depositoService.save(deposito);
            return ResponseEntity.ok(depositoMapper.toDTO(saved));

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

    @GetMapping
    public ResponseEntity<List<DepositoDTO>> getAll() {
        try {
            List<Deposito> depositos = depositoService.findAll();
            List<DepositoDTO> dtos = depositos.stream()
                                             .map(depositoMapper::toDTO)
                                             .collect(Collectors.toList());

            return ResponseEntity.ok(dtos);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepositoDTO> getById(@PathVariable Long id) {
        try {
            Deposito deposito = depositoService.findById(id);
            return ResponseEntity.ok(depositoMapper.toDTO(deposito));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepositoDTO> update(@PathVariable Long id, @RequestBody DepositoDTO dto) {
        try {
            Deposito deposito = depositoMapper.toModel(dto);
            Deposito updated = depositoService.update(id, deposito);

            return ResponseEntity.ok(depositoMapper.toDTO(updated));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            depositoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
