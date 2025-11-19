package com.tp_backend.ms_logistica.controller;

import com.tp_backend.ms_logistica.dto.DistanciaDTO;
import com.tp_backend.ms_logistica.service.GeoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/geo")
@RequiredArgsConstructor
public class GeoController {

    private final GeoService geoService;

    @GetMapping("/distancia")
    public DistanciaDTO calcular(
            @RequestParam String origen,
            @RequestParam String destino) throws Exception {

        return geoService.calcularDistancia(origen, destino);
    }
}

