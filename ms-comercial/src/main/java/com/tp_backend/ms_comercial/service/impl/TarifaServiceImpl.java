package com.tp_backend.ms_comercial.service.impl;

import jakarta.persistence.EntityNotFoundException;
import com.tp_backend.ms_comercial.model.Tarifa;
import com.tp_backend.ms_comercial.service.ContenedorService;
import com.tp_backend.ms_comercial.dto.TarifaDTO;
import com.tp_backend.ms_comercial.dto.CreateTarifaRequest;
import com.tp_backend.ms_comercial.enums.EstadoEnum;
import com.tp_backend.ms_comercial.model.Contenedor;
import com.tp_backend.ms_comercial.repository.TarifaRepository;
import com.tp_backend.ms_comercial.service.TarifaService;
import org.springframework.stereotype.Service;

import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TarifaServiceImpl implements TarifaService {

    private final TarifaRepository tarifaRepository;
    private final ContenedorService contenedorService;

    @Override
    public List<Tarifa> findAll() {
        return tarifaRepository.findAll();
    }

    @Override
    public Tarifa findById(Long id) {
        return tarifaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarifa no encontrada"));
    }

    @Override
    public Tarifa save(CreateTarifaRequest dto) {
	Contenedor contenedor = contenedorService.findById(dto.contenedorId());

	Tarifa newTarifa = new Tarifa(
		null,
		dto.tipo(),
		dto.monto(),
		dto.costo_por_combustible(),
		dto.costo_por_kilometro(),
		dto.camionId(),
		dto.depositoId(),
		contenedor,
		dto.rutaId()
	);

        return tarifaRepository.save(newTarifa);
    }

    @Override
    public Tarifa update(Long id, TarifaDTO dto) {
        Tarifa existingTar = tarifaRepository.findById(id)
	    .orElseThrow(() -> new EntityNotFoundException("TTrifa not found with id " + id));

	Contenedor contenedor = contenedorService.findById(dto.contenedorId());

	existingTar.setTipo(dto.tipo());
	existingTar.setMonto(dto.monto());
	existingTar.setCosto_por_combustible(dto.costo_por_combustible());
	existingTar.setCosto_por_kilometro(dto.costo_por_kilometro());
	existingTar.setCamionId(dto.camionId());
	existingTar.setDepositoId(dto.depositoId());
	existingTar.setContenedor(contenedor);
	existingTar.setRutaId(dto.rutaId());

        return tarifaRepository.save(existingTar);
    }

    @Override
    public void delete(Long id) {
        tarifaRepository.deleteById(id);
    }
}

