package com.tp_backend.ms_comercial.mapper;

import com.tp_backend.ms_comercial.dto.*;
import com.tp_backend.ms_comercial.model.Contenedor;
import com.tp_backend.ms_comercial.enums.EstadoEnum;
import org.springframework.stereotype.Component;

@Component
public class ContenedorMapper {

    public ContenedorDTO toDTO(Contenedor contenedor) {
        if (contenedor == null) return null;
        return new ContenedorDTO(
                contenedor.getId(),
                contenedor.getCodigo(),
                contenedor.getCapacidadTn(),
                contenedor.getVolumen(),
                contenedor.getEstado() != null ? contenedor.getEstado().name() : null,
                contenedor.getDepositoId()
        );
    }

    public Contenedor toModel(CreateContenedorRequest dto) {
        if (dto == null) return null;
        return new Contenedor(
                null,
                dto.codigo(),
                dto.capacidadTn(),
                dto.volumen(),
	        dto.estado() != null ? EstadoEnum.valueOf(dto.estado()) : null,
                dto.depositoId()
        );
    }

    public Contenedor toModel(ContenedorDTO dto) {
        if (dto == null) return null;
        return new Contenedor(
                dto.id(),
                dto.codigo(),
                dto.capacidadTn(),
                dto.volumen(),
	        dto.estado() != null ? EstadoEnum.valueOf(dto.estado()) : null,
                dto.depositoId()
        );
    }
}

