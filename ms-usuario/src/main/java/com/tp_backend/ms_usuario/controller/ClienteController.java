package com.tp_backend.ms_usuario.controller;

import com.tp_backend.ms_usuario.dto.ClienteDTO;
import com.tp_backend.ms_usuario.dto.ClienteCreateRequestDTO;
import com.tp_backend.ms_usuario.mapper.ClienteMapper;
import com.tp_backend.ms_usuario.model.Cliente;
import com.tp_backend.ms_usuario.service.ClienteService;




import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;
    private final ClienteMapper clienteMapper;

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@RequestBody ClienteCreateRequestDTO dto) {
        try {
            Cliente cliente = clienteMapper.toModel(dto);
            Cliente saved = clienteService.save(cliente);
            return ResponseEntity.ok(clienteMapper.toDTO(saved));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAll() {
        try {
            List<Cliente> clientes = clienteService.findAll();
            List<ClienteDTO> dtos = clientes.stream()
                    .map(clienteMapper::toDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable Long id) {
        try {
            Cliente cliente = clienteService.findById(id);
            return ResponseEntity.ok(clienteMapper.toDTO(cliente));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody ClienteDTO dto) {
        try {
            Cliente cliente = clienteMapper.toModel(dto);
            Cliente updated = clienteService.update(id, cliente);
            return ResponseEntity.ok(clienteMapper.toDTO(updated));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            clienteService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    

}

