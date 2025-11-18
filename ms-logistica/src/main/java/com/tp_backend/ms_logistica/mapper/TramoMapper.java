package com.tp_backend.ms_logistica.mapper;

import com.tp_backend.ms_logistica.dto.TramoDTO;
import com.tp_backend.ms_logistica.dto.CreateTramoRequest;
import com.tp_backend.ms_logistica.enums.EstadoEnum;
import com.tp_backend.ms_logistica.model.Tramo;
import org.springframework.stereotype.Component;
import java.util.Objects; // Used for safer Long comparison/setting

@Component
public class TramoMapper {

    public TramoDTO toDTO(Tramo tramo) {
        if (tramo == null) return null;
        return new TramoDTO(
            tramo.getId(),
            tramo.getOrigen(),
            tramo.getDestino(),
            tramo.getTipo(),
            tramo.getDistanciaKm(),
            tramo.getEstado() != null ? tramo.getEstado().name() : null,
            tramo.getFechaInicio(),
            tramo.getFechaFin(),
            tramo.getCostoEstimado(),
            tramo.getCostoFinal(),
            tramo.getCamion().getId(),
            tramo.getRuta().getId(),
            tramo.getDepositoOrigen().getId(),
            tramo.getDepositoDestino().getId()
        );
    }

    public Tramo toModel(CreateTramoRequest dto) {
        if (dto == null) return null;
        return new Tramo(
            null, // ID is null for creation
            dto.origen(),
            dto.destino(),
            dto.tipo(),
            dto.distanciaKm(),
            dto.estado() != null ? EstadoEnum.valueOf(dto.estado()) : null,
            dto.fechaInicio(),
            dto.fechaFin(),
            dto.costoEstimado(),
            dto.costoFinal(),
            null,
            null,
            null,
            null 
        );
    }

    public Tramo toModel(TramoDTO dto) {
        if (dto == null) return null;
        return new Tramo(
            dto.id(),
            dto.origen(),
            dto.destino(),
            dto.tipo(),
            dto.distanciaKm(),
            dto.estado() != null ? EstadoEnum.valueOf(dto.estado()) : null,
            dto.fechaInicio(),
            dto.fechaFin(),
            dto.costoEstimado(),
            dto.costoFinal(),
            null,
            null,
            null,
            null 
        );
    }
}
