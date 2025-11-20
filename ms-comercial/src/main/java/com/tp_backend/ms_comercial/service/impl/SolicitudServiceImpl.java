package com.tp_backend.ms_comercial.service.impl;

import jakarta.persistence.EntityNotFoundException;
import com.tp_backend.ms_comercial.model.Solicitud;
import com.tp_backend.ms_comercial.enums.EstadoEnum;
import com.tp_backend.ms_comercial.dto.SolicitudDTO;
import com.tp_backend.ms_comercial.dto.CreateSolicitudRequest;
import com.tp_backend.ms_comercial.service.ContenedorService;
import com.tp_backend.ms_comercial.model.Contenedor;
import com.tp_backend.ms_comercial.repository.SolicitudRepository;
import com.tp_backend.ms_comercial.service.SolicitudService;
import org.springframework.stereotype.Service;

import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements SolicitudService {

    private final SolicitudRepository solicitudRepository;
    private final ContenedorService contenedorService;

    @Override
    public List<Solicitud> findAll() {
        return solicitudRepository.findAll();
    }

    @Override
    public Solicitud findById(Long id) {
        return solicitudRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
    }

    @Override
    public Solicitud save(CreateSolicitudRequest dto) {
	Contenedor contenedor = contenedorService.findById(dto.contenedorId());

	Solicitud newSolicitud = new Solicitud(
		null,
		dto.fechaSolicitud(),
		dto.origen(),
		dto.destino(),
		dto.costoEstimado(),
		dto.costoFinal(),
		dto.tiempoEstimado(),
		dto.tiempoFinal(),
		contenedor,
		dto.clienteId(),
		dto.estado() != null ? EstadoEnum.valueOf(dto.estado()) : null,
		dto.rutaId()
	);

        return solicitudRepository.save(newSolicitud);
    }

    @Override
    public Solicitud update(Long id, SolicitudDTO dto) {
        Solicitud existingSol = solicitudRepository.findById(id)
	    .orElseThrow(() -> new EntityNotFoundException("Solicitud not found with id " + id));


	Contenedor contenedor = contenedorService.findById(dto.contenedorId());

	existingSol.setFechaSolicitud(dto.fechaSolicitud());
	existingSol.setOrigen(dto.origen());
	existingSol.setDestino(dto.destino());
	existingSol.setCostoEstimado(dto.costoEstimado());
	existingSol.setCostoFinal(dto.costoFinal());
	existingSol.setTiempoEstimado(dto.tiempoEstimado());
	existingSol.setTiempoFinal(dto.tiempoFinal());
	existingSol.setContenedor(contenedor);
	existingSol.setClienteId(dto.clienteId());
	existingSol.setEstado(dto.estado() != null ? EstadoEnum.valueOf(dto.estado()) : null);
	existingSol.setRutaId(dto.rutaId());

        return solicitudRepository.save(existingSol);
    }

    @Override
    public void delete(Long id) {
        solicitudRepository.deleteById(id);
    }
}

