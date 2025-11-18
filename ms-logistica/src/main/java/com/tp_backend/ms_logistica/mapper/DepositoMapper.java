package com.tp_backend.ms_logistica.mapper;

import com.tp_backend.ms_logistica.dto.DepositoDTO;
import com.tp_backend.ms_logistica.dto.CreateDepositoRequest;
import com.tp_backend.ms_logistica.enums.EstadoEnum;
import com.tp_backend.ms_logistica.model.Deposito;
import org.springframework.stereotype.Component;

@Component
public class DepositoMapper {

    public DepositoDTO toDTO(Deposito deposito) {
        if (deposito == null) return null;
        return new DepositoDTO(
            deposito.getId(),
            deposito.getNombre(),
            deposito.getUbicacion(),
            deposito.getCiudad(),
            deposito.getCoordenadas(),
            deposito.getCapacidad(),
            deposito.getCostoXDia(),
            deposito.getEstado() != null ? deposito.getEstado().name() : null
        );
    }

    public Deposito toModel(CreateDepositoRequest dto) {
        if (dto == null) return null;
        return new Deposito(
            null, // ID is null for creation
            dto.nombre(),
            dto.ubicacion(),
            dto.ciudad(),
            dto.coordenadas(),
            dto.capacidad(),
            dto.costoXDia(),
            dto.estado() != null ? EstadoEnum.valueOf(dto.estado()) : null
        );
    }

    public Deposito toModel(DepositoDTO dto) {
        if (dto == null) return null;
        return new Deposito(
            dto.id(),
            dto.nombre(),
            dto.ubicacion(),
            dto.ciudad(),
            dto.coordenadas(),
            dto.capacidad(),
            dto.costoXDia(),
            dto.estado() != null ? EstadoEnum.valueOf(dto.estado()) : null
        );
    }
}
