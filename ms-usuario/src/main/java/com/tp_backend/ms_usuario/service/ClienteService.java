package com.tp_backend.ms_usuario.service;

import com.tp_backend.ms_usuario.model.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente save(Cliente cliente);

    Cliente update(Long id, Cliente cliente);

    void delete(Long id);

    Cliente findById(Long id);

    Cliente findByKeycloakUserId(String keycloakUserId);

    List<Cliente> findAll();
}

