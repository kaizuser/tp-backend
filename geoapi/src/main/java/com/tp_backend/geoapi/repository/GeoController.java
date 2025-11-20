package com.tp_backend.geoapi.repository;


import com.tp_backend.geoapi.dto.DistanciaDTO;
import com.tp_backend.geoapi.service.GeoService;
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

