package com.tp_backend.ms_logistica; 

import com.tp_backend.ms_logistica.dto.CreateTramoRequest;
import com.tp_backend.ms_logistica.dto.TramoDTO;
import com.tp_backend.ms_logistica.model.Camion;
import com.tp_backend.ms_logistica.model.Tramo;
import com.tp_backend.ms_logistica.model.Ruta;
import com.tp_backend.ms_logistica.model.Deposito;
import com.tp_backend.ms_logistica.service.CamionService;
import com.tp_backend.ms_logistica.service.TramoService;
import com.tp_backend.ms_logistica.service.DepositoService;
import com.tp_backend.ms_logistica.service.RutaService;
import com.tp_backend.ms_logistica.enums.EstadoEnum;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test") 
public class IntegrationTest {

    @Autowired
    private TramoService tramoService;

    @Autowired
    private CamionService camionService; 

    @Autowired
    private RutaService rutaService;

    @Autowired
    private DepositoService depositoService; 

    @Test
    void testCreateTramo_Success() {
        // 1️⃣ Create Camion
        Camion camion = new Camion();
        camion.setPatente("ABC123");
        camion.setModeloNombreTransportista("Model X");
        camion.setTelefonoTransportista("123456789");
        camion.setVolumen(20.0);
        camion.setPeso(5000.0);
        camion.setEstado(EstadoEnum.ACTIVO);
        camion.setCostos(1000.0);
        camion.setCostoXKilometro(10.0);
        camion.setCostoXCombustible(5.0);
	camion.setEmpleadoId(9876543210L);
        camion = camionService.save(camion);

        // 2️⃣ Create Ruta
        Ruta ruta = new Ruta();
        ruta.setDescripcion("RUTA 1");
	ruta.setFechaInicio(LocalDate.now());
	ruta.setFechaFin(LocalDate.now());
        ruta = rutaService.save(ruta);

        // 3️⃣ Create Depositos
        Deposito depositoOrigen = new Deposito();
        depositoOrigen.setNombre("Deposito A");
        depositoOrigen.setUbicacion("Deposito A");
        depositoOrigen.setCiudad("Deposito A");
        depositoOrigen.setCoordenadas("Deposito A");
	depositoOrigen.setEstado(EstadoEnum.ACTIVO);
        depositoOrigen = depositoService.save(depositoOrigen);

        Deposito depositoDestino = new Deposito();
        depositoDestino.setNombre("Deposito B");
        depositoDestino.setUbicacion("Deposito B");
        depositoDestino.setCiudad("Deposito B");
        depositoDestino.setCoordenadas("Deposito B");
        depositoDestino.setEstado(EstadoEnum.ACTIVO);
        depositoDestino = depositoService.save(depositoDestino);

        // 4️⃣ Create Tramo
        CreateTramoRequest request = new CreateTramoRequest(
                "Ciudad A",
                "Ciudad B",
                "Tipo 1",
                100.0,
                EstadoEnum.ACTIVO.name(),
                null,
                null,
                500.0,
                550.0,
                camion.getId(),
                ruta.getId(),
                depositoOrigen.getId(),
                depositoDestino.getId()
        );

        Tramo tramo = tramoService.save(request);

        // 5️⃣ Assertions
        assertNotNull(tramo.getId());
        assertEquals("Ciudad A", tramo.getOrigen());
        assertEquals("Ciudad B", tramo.getDestino());
        assertEquals(camion.getId(), tramo.getCamion().getId());
        assertEquals(ruta.getId(), tramo.getRuta().getId());
        assertEquals(depositoOrigen.getId(), tramo.getDepositoOrigen().getId());
        assertEquals(depositoDestino.getId(), tramo.getDepositoDestino().getId());
        assertEquals(EstadoEnum.ACTIVO, tramo.getEstado());
        assertEquals(100.0, tramo.getDistanciaKm());
        assertEquals(500.0, tramo.getCostoEstimado());
        assertEquals(550.0, tramo.getCostoFinal());

	System.out.println(tramo);
	System.out.println(depositoOrigen);
	System.out.println(depositoDestino);
	System.out.println(ruta);
	System.out.println(camion);

	TramoDTO updatedTramo = new TramoDTO(
		// Scalar Fields (New Values)
		null,
		tramo.getOrigen(), // Keep Origin the same
		"Mendoza",                 // New Destination
		tramo.getTipo(),
		tramo.getDistanciaKm(),
		"EN_CURSO",                // <-- Change the state
		tramo.getFechaInicio(),
		tramo.getFechaFin(),
		tramo.getCostoEstimado(),
		745.50,                    // <-- Set the final cost

		// Relationship IDs (Must use existing IDs)
		tramo.getCamion().getId(),
		tramo.getRuta().getId(),
		tramo.getDepositoOrigen().getId(),
		tramo.getDepositoDestino().getId()
        );

	Tramo newTramo = tramoService.update(tramo.getId(), updatedTramo);

	System.out.println(newTramo);
    }
}
