package com.tp_backend.ms_usuario.service.impl;


import com.tp_backend.ms_usuario.dto.ClienteCreateRequestDTO;
import com.tp_backend.ms_usuario.dto.ClienteDTO;
import com.tp_backend.ms_usuario.mapper.ClienteMapper;
import com.tp_backend.ms_usuario.model.Cliente;
import com.tp_backend.ms_usuario.repository.ClienteRepository;
import com.tp_backend.ms_usuario.service.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Long id, Cliente cliente) {
        Cliente existing = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));

        existing.setDni(cliente.getDni());
        existing.setNombre(cliente.getNombre());
        existing.setDireccion(cliente.getDireccion());
        existing.setTelefono(cliente.getTelefono());
        existing.setEmail(cliente.getEmail());
        existing.setKeycloakUserId(cliente.getKeycloakUserId());

        return clienteRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
    }

    @Override
    public Cliente findByKeycloakUserId(String keycloakUserId) {
        return clienteRepository.findByKeycloakUserId(keycloakUserId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    
}

