package com.tp_backend.ms_usuario;

import org.springframework.test.context.ActiveProfiles;
import com.tp_backend.ms_usuario.dto.ClienteCreateRequestDTO;
import com.tp_backend.ms_usuario.dto.EmpleadoCreateRequestDTO;
import com.tp_backend.ms_usuario.dto.ClienteDTO;
import com.tp_backend.ms_usuario.dto.EmpleadoDTO;
import com.tp_backend.ms_usuario.enums.EmpleadoRol;
import com.tp_backend.ms_usuario.service.ClienteService;
import com.tp_backend.ms_usuario.service.EmpleadoService;
import com.tp_backend.ms_usuario.MsUsuarioApplication; 
import com.tp_backend.ms_usuario.model.Empleado;
import com.tp_backend.ms_usuario.model.Cliente;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@ActiveProfiles("test")
@SpringBootTest(classes = MsUsuarioApplication.class) 
public class ClienteEmpleadoIntegrationTest {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private ClienteService clienteService;

    @Test
    void testCrearYModificarClienteYEmpleado() {

        System.out.println("===== CREANDO EMPLEADO =====");
        Empleado empleado = new Empleado();
        empleado.setNombre("Lucas");
        empleado.setDni("123123123");
	empleado.setRol(EmpleadoRol.TRANSPORTISTA);

        empleado = empleadoService.save(empleado);
        System.out.println("Empleado creado: " + empleado);


        System.out.println("\n===== CREANDO CLIENTE =====");
        Cliente cliente = new Cliente();
        cliente.setNombre("Carla");
        cliente.setDni("213123123");
        cliente.setEmail("carla@gmail.com");

        cliente = clienteService.save(cliente);
        System.out.println("Cliente creado: " + cliente);


        System.out.println("\n===== MODIFICANDO EMPLEADO =====");
        Empleado nuevoEmp = new Empleado();
        nuevoEmp.setNombre("Lucas");
        nuevoEmp.setDni("nuevoDNI");
	nuevoEmp.setRol(EmpleadoRol.TRANSPORTISTA);

        Empleado empleadoModificado = empleadoService.update(empleado.getIdEmpleado(), nuevoEmp);
        System.out.println("Empleado modificado: " + empleadoModificado);


        System.out.println("\n===== MODIFICANDO CLIENTE =====");
        Cliente nuevoCli = new Cliente();
        nuevoCli.setNombre("Carla");
        nuevoCli.setDni("nuevoDni");
        nuevoCli.setEmail("carla@gmail.com");

        Cliente clienteModificado = clienteService.update(cliente.getIdCliente(), nuevoCli);
        System.out.println("Cliente modificado: " + clienteModificado);


        System.out.println("\n===== ESTADOS FINALES =====");
        System.out.println("Empleado final: " + empleadoService.findById(empleado.getIdEmpleado()));
        System.out.println("Cliente final: " + clienteService.findById(cliente.getIdCliente()));
    }
}

