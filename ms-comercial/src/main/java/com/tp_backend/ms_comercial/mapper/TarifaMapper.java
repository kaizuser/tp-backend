package com.tp_backend.ms_comercial.mapper;

import com.tp_backend.ms_comercial.dto.*;
import com.tp_backend.ms_comercial.model.Tarifa;
import com.tp_backend.ms_comercial.model.Contenedor;
import org.springframework.stereotype.Component;

@Component
public class TarifaMapper {

    public TarifaDTO toDTO(Tarifa tarifa) {
        if (tarifa == null) return null;
        return new TarifaDTO(
                tarifa.getId(),
                tarifa.getTipo(),
                tarifa.getMonto(),
                tarifa.getCosto_por_combustible(),
                tarifa.getCosto_por_kilometro(),
                tarifa.getCamionId(),
                tarifa.getDepositoId(),
                tarifa.getContenedor().getId(),
                tarifa.getRutaId()
        );
    }

}

