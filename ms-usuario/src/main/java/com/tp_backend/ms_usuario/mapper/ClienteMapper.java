package com.tp_backend.ms_usuario.mapper;

import org.springframework.stereotype.Component;

import com.tp_backend.ms_usuario.dto.ClienteDTO;
import com.tp_backend.ms_usuario.dto.ClienteCreateRequestDTO;
import com.tp_backend.ms_usuario.model.Cliente;

@Component
public class ClienteMapper {

    public ClienteDTO toDTO(Cliente cliente) {
        if (cliente == null) return null;

        return new ClienteDTO(
                cliente.getIdCliente(),
                cliente.getDni(),
                cliente.getNombre(),
                cliente.getDireccion(),
                cliente.getTelefono(),
                cliente.getEmail(),
                cliente.getKeycloakUserId()
        );
    }

    public Cliente toModel(ClienteCreateRequestDTO dto) {
        if (dto == null) return null;

        Cliente cliente = new Cliente();
        cliente.setIdCliente(null); 
        cliente.setDni(dto.dni());
        cliente.setNombre(dto.nombre());
        cliente.setDireccion(dto.direccion());
        cliente.setTelefono(dto.telefono());
        cliente.setEmail(dto.email());
        cliente.setKeycloakUserId(dto.keycloakUserId());

        return cliente;
    }

    public Cliente toModel(ClienteDTO dto) {
        if (dto == null) return null;

        Cliente cliente = new Cliente();
        cliente.setIdCliente(dto.idCliente());
        cliente.setDni(dto.dni());
        cliente.setNombre(dto.nombre());
        cliente.setDireccion(dto.direccion());
        cliente.setTelefono(dto.telefono());
        cliente.setEmail(dto.email());
        cliente.setKeycloakUserId(dto.keycloakUserId());

        return cliente;
    }
}

