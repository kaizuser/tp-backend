package com.tp_backend.ms_logistica.mapper;

import com.tp_backend.ms_logistica.dto.CamionDTO;
import com.tp_backend.ms_logistica.dto.CreateCamionRequest;
import com.tp_backend.ms_logistica.enums.EstadoEnum;
import com.tp_backend.ms_logistica.model.Camion;
import org.springframework.stereotype.Component;

// CamionMapper.java
@Component
public class CamionMapper {

    public CamionDTO toDTO(Camion camion) {
        if (camion == null) return null;
        return new CamionDTO(
            camion.getId(),
            camion.getPatente(),
            camion.getModeloNombreTransportista(),
            camion.getTelefonoTransportista(),
            camion.getVolumen(),
            camion.getPeso(),
	    camion.getEstado() != null ? camion.getEstado().name() : null,
            camion.getCostos(),
            camion.getCostoXKilometro(),
            camion.getCostoXCombustible(),
            camion.getEmpleadoId()
        );
    }

    public Camion toModel(CreateCamionRequest dto) {
        if (dto == null) return null;
        return new Camion(
            null, // ID is null for creation
            dto.patente(),
            dto.modeloNombreTransportista(),
            dto.telefonoTransportista(),
            dto.volumen(),
            dto.peso(),
	    dto.estado() != null ? EstadoEnum.valueOf(dto.estado()) : null,
            dto.costos(),
            dto.costoXKilometro(),
            dto.costoXCombustible(),
            dto.empleadoId()
        );
    }

    public Camion toModel(CamionDTO dto) {
        if (dto == null) return null;
        return new Camion(
            dto.id(),
            dto.patente(),
            dto.modeloNombreTransportista(),
            dto.telefonoTransportista(),
            dto.volumen(),
            dto.peso(),
	    dto.estado() != null ? EstadoEnum.valueOf(dto.estado()) : null,
            dto.costos(),
            dto.costoXKilometro(),
            dto.costoXCombustible(),
            dto.empleadoId()
        );
    }
}

