package com.tp_backend.ms_comercial.mapper;

import com.tp_backend.ms_comercial.dto.*;
import com.tp_backend.ms_comercial.model.Solicitud;
import org.springframework.stereotype.Component;

@Component
public class SolicitudMapper {
    public SolicitudDTO toDTO(Solicitud solicitud) {
        if (solicitud == null) return null;
        return new SolicitudDTO(
                solicitud.getId(),
                solicitud.getFechaSolicitud(),
                solicitud.getOrigen(),
                solicitud.getDestino(),
                solicitud.getCostoEstimado(),
		solicitud.getCostoFinal(),
                solicitud.getTiempoEstimado(),
                solicitud.getTiempoFinal(),
                solicitud.getContenedor().getId(),
                solicitud.getClienteId(),
                solicitud.getEstado() != null ? solicitud.getEstado().name() : null,
                solicitud.getRutaId()
        );
    }
}

