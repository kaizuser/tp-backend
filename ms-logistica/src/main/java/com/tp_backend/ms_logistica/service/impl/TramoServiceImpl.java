package com.tp_backend.ms_logistica.service.impl;

import jakarta.persistence.EntityNotFoundException;
import com.tp_backend.ms_logistica.model.Tramo;
import com.tp_backend.ms_logistica.model.Camion;
import com.tp_backend.ms_logistica.model.Ruta;
import com.tp_backend.ms_logistica.model.Deposito;
import com.tp_backend.ms_logistica.repository.TramoRepository;
import com.tp_backend.ms_logistica.service.TramoService;
import com.tp_backend.ms_logistica.service.DepositoService;
import com.tp_backend.ms_logistica.service.RutaService;
import com.tp_backend.ms_logistica.service.CamionService;
import com.tp_backend.ms_logistica.enums.EstadoEnum;
import com.tp_backend.ms_logistica.dto.TramoDTO;
import com.tp_backend.ms_logistica.dto.CreateTramoRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TramoServiceImpl implements TramoService {

    private final TramoRepository tramoRepository;
    private final DepositoService depositoService;
    private final RutaService rutaService;
    private final CamionService camionService;

    @Override
    public List<Tramo> findAll() {
        return tramoRepository.findAll();
    }

    @Override
    public Tramo findById(Long id) {
        return tramoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tramo no encontrado"));
    }

    @Override
    public Tramo save(CreateTramoRequest dto) {
	    Camion camion = camionService.findById(dto.camionId()); // Assume service handles NotFoundException
	    Ruta ruta = rutaService.findById(dto.rutaId());
	    Deposito depositoOrigen = depositoService.findById(dto.depositoOrigenId());
	    Deposito depositoDestino = depositoService.findById(dto.depositoDestinoId());

	    Tramo newTramo = new Tramo(
		    null,
		    dto.origen(),
		    dto.destino(),
		    dto.tipo(),
		    dto.distanciaKm(),
		    dto.estado() != null ? EstadoEnum.valueOf(dto.estado()) : null,
		    dto.fechaInicio(),
		    dto.fechaFin(),
		    dto.costoEstimado(),
		    dto.costoFinal(),
		    camion,
		    ruta,
		    depositoOrigen,
		    depositoDestino
            );

            return tramoRepository.save(newTramo);
    }

    @Override
    public Tramo update(Long id, TramoDTO dto) {
	    Tramo existingTramo = tramoRepository.findById(id)
	    .orElseThrow(() -> new EntityNotFoundException("Tramo not found with id " + id));


	    Camion camion = camionService.findById(dto.camionId());
            Ruta ruta = rutaService.findById(dto.rutaId());
	    Deposito depositoOrigen = depositoService.findById(dto.depositoOrigenId());
	    Deposito depositoDestino = depositoService.findById(dto.depositoDestinoId());

	    existingTramo.setOrigen(dto.origen());
	    existingTramo.setDestino(dto.destino());
	    existingTramo.setTipo(dto.tipo());
	    existingTramo.setDistanciaKm(dto.distanciaKm());
	    existingTramo.setEstado(dto.estado() != null ? EstadoEnum.valueOf(dto.estado()) : null);
	    existingTramo.setFechaInicio(dto.fechaInicio());
	    existingTramo.setFechaFin(dto.fechaFin());
	    existingTramo.setCostoEstimado(dto.costoEstimado());
	    existingTramo.setCostoFinal(dto.costoFinal());

	    existingTramo.setCamion(camion);
	    existingTramo.setRuta(ruta);
	    existingTramo.setDepositoOrigen(depositoOrigen);
	    existingTramo.setDepositoDestino(depositoDestino);

            return tramoRepository.save(existingTramo);
    }

    @Override
    public void delete(Long id) {
        tramoRepository.deleteById(id);
    }
}

