package com.tp_backend.ms_logistica.mapper;

import com.tp_backend.ms_logistica.dto.RutaDTO;
import com.tp_backend.ms_logistica.dto.CreateRutaRequest;
import com.tp_backend.ms_logistica.model.Ruta;
import org.springframework.stereotype.Component;

@Component
public class RutaMapper {

    public RutaDTO toDTO(Ruta ruta) {
        if (ruta == null) return null;
        return new RutaDTO(
            ruta.getId(),
            ruta.getDescripcion(),
            ruta.getFechaInicio(),
            ruta.getFechaFin(),
            ruta.getCantidadTramos(),
            ruta.getCantidadDepositos()
        );
    }

    public Ruta toModel(CreateRutaRequest dto) {
        if (dto == null) return null;
        return new Ruta(
            null, // ID is null for creation
            dto.descripcion(),
            dto.fechaInicio(),
            dto.fechaFin(),
            dto.cantidadTramos(),
            dto.cantidadDepositos()
        );
    }

    public Ruta toModel(RutaDTO dto) {
        if (dto == null) return null;
        return new Ruta(
            dto.id(),
            dto.descripcion(),
            dto.fechaInicio(),
            dto.fechaFin(),
            dto.cantidadTramos(),
            dto.cantidadDepositos()
        );
    }
}
