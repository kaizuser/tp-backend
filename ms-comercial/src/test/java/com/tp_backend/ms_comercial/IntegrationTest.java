package com.tp_backend.ms_comercial;

import org.springframework.transaction.annotation.Transactional;
import com.tp_backend.ms_comercial.dto.*;
import com.tp_backend.ms_comercial.enums.EstadoEnum;
import com.tp_backend.ms_comercial.model.Contenedor;
import com.tp_backend.ms_comercial.model.Solicitud;
import com.tp_backend.ms_comercial.model.Tarifa;
import com.tp_backend.ms_comercial.mapper.ContenedorMapper;
import com.tp_backend.ms_comercial.service.ContenedorService;
import com.tp_backend.ms_comercial.service.SolicitudService;
import com.tp_backend.ms_comercial.service.TarifaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class IntegrationTest {

    @Autowired
    private ContenedorService contenedorService;

    @Autowired
    private SolicitudService solicitudService;

    @Autowired
    private TarifaService tarifaService;

    @Autowired
    private ContenedorMapper contenedorMapper;

    @Test
    @Transactional
    void testCreateContenedorSolicitudTarifa() {

        Contenedor contenedor = new Contenedor();
        contenedor.setCodigo(999L);
        contenedor.setCapacidadTn(40.0);
        contenedor.setVolumen(22.0);
        contenedor.setEstado(EstadoEnum.EN_TRANSITO);
        contenedor.setDepositoId(10L);
        contenedor = contenedorService.save(contenedor);

        CreateSolicitudRequest solicitudReq = new CreateSolicitudRequest(
                LocalDate.now(),
                "Buenos Aires",
                "Mendoza",
                1500.0,
                1800.0,
                "15h",
                "18h",
                contenedor.getId(),
                300L,
                EstadoEnum.EN_VIAJE.name(),
                777L
        );

        Solicitud solicitud = solicitudService.save(solicitudReq);

        CreateTarifaRequest tarifaReq = new CreateTarifaRequest(
                "STANDARD",
                5000.0,
                400.0,
                35.0,
                50L,
                60L,
                contenedor.getId(),
                888L
        );

        Tarifa tarifa = tarifaService.save(tarifaReq);

        assertNotNull(contenedor.getId());
        assertEquals(999L, contenedor.getCodigo());
        assertEquals(40.0, contenedor.getCapacidadTn());

        assertNotNull(solicitud.getId());
        assertEquals("Buenos Aires", solicitud.getOrigen());
        assertEquals(contenedor.getId(), solicitud.getContenedor().getId());

        assertNotNull(tarifa.getId());
        assertEquals("STANDARD", tarifa.getTipo());
        assertEquals(contenedor.getId(), tarifa.getContenedor().getId());

	System.out.println(tarifa);
	System.out.println(solicitud);
	System.out.println(contenedor);

	SolicitudDTO upSolicitud = new SolicitudDTO(
		null,
		solicitud.getFechaSolicitud(),
		"Cordoba",
		"Salta",
		2500.0,
		solicitud.getCostoFinal(),
		"20h",
		solicitud.getTiempoFinal(),
		contenedor.getId(),
		999L,
		 EstadoEnum.EN_DEPOSITO.name(),
		solicitud.getRutaId()
	);

	TarifaDTO upTarifa = new TarifaDTO(
		null,
		"PREMIUM",
		tarifa.getMonto(),
		999.0,
		tarifa.getCosto_por_kilometro(),
		tarifa.getCamionId(),
		tarifa.getDepositoId(),
		contenedor.getId(),
		444L
	);

	ContenedorDTO upContenedor = new ContenedorDTO(
		null,
		12345L,
		contenedor.getCapacidadTn(),
		99.9,
		EstadoEnum.ENTREGADO.name(),
		contenedor.getDepositoId()
	);

        Contenedor finalContenedor = contenedorMapper.toModel(upContenedor);

        Tarifa newTarifa = tarifaService.update(tarifa.getId(), upTarifa);
        Solicitud newSolicitud = solicitudService.update(solicitud.getId(), upSolicitud);
        Contenedor newContenedor = contenedorService.update(contenedor.getId(), finalContenedor);


	System.out.println(newTarifa);
	System.out.println(newSolicitud);
	System.out.println(newContenedor);
    }
}

