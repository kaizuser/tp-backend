To do:

1) todos los requerimientos dentro de cada ms 

2) API Client interno entre microservicios

3) verificar que cada requerimiento funcione con: @PreAuthorize("hasRole('rol')") (lo hago a la tarde antes de q entremos todos)

4) dockerización individual para cada ms 

5) levantar todo y empezar a probar con postman

Extra: 
Creo que no hace falta meterlo en el rar asique lo podemos hacer en el finde, el tema de la presentación:
dividir que explica cada uno, la secuencia y documentación con Swagger / OpenAPI y los diagramas actualizados.
La tiro para robar un poco de tiempo, si llegamos para agregarlo al rar mejor.




Detalladamente el punto 2

2) API CLIENT INTERNO ENTRE MICROSERVICIOS (Apunte 18)

En un sistema de microservicios, un MS debe pedir datos a otro MS.
No se deben compartir DB.

💡 Es decir:

MS Logística NO accede a la DB de MS Usuarios

MS Comercial NO accede a la DB de MS Usuarios

Cada MS expone APIs REST, y otros MS las consumen con un API Client interno

Esto el apunte lo explica EXACTO.

📌 ¿Qué llamadas internas necesitás según el TPI?
✔ Logística consulta Usuarios para validar que el chófer exista
GET /gestion-usuario/empleado/{id}

✔ Comercial consulta Usuarios para verificar el cliente
GET /gestion-usuario/cliente/{id}

✔ Logística consulta Comercial para obtener datos del contenedor
GET /gestion-comercial/contenedor/{id}

✔ Logística consulta Comercial para obtener tarifas
GET /gestion-comercial/tarifa/{id}

📌 ¿Qué herramienta usar para estas llamadas internas?

El apunte permite dos opciones:

✔ OPTION 1 — RestTemplate (simple, clásico)
✔ OPTION 2 — WebClient (moderno, reactivo)

Te recomiendo RestTemplate, más fácil para microservicios sin Reactor.

🧱 Paso 1: Definir el RestTemplate global

En cada MS que llame a otro, debe existir este Bean:

@Bean
public RestTemplate restTemplate() {
    return new RestTemplate();
}

🧱 Paso 2: Crear un "client" interno por cada MS que consumas
Ejemplo: Logística quiere consultar Usuarios

Crea:

src/main/java/.../client/UsuarioClient.java

@Service
@RequiredArgsConstructor
public class UsuarioClient {

    private final RestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8081/gestion-usuario";

    public UsuarioDTO obtenerEmpleado(Integer id) {
        return restTemplate.getForObject(
            BASE_URL + "/empleado/" + id,
            UsuarioDTO.class
        );
    }
}


✔ Esto es EXACTAMENTE lo que exige el apunte 18.
✔ Queda claro quién consulta a quién.

🧱 Paso 3: Inyectar el client en el servicio que corresponde

Ejemplo:

@Service
@RequiredArgsConstructor
public class TramoService {

    private final UsuarioClient usuarioClient;

    public void asignarCamion(Tramo t) {

        UsuarioDTO chofer = usuarioClient.obtenerEmpleado(t.getIdChofer());

        if (chofer == null) {
            throw new RuntimeException("Chofer inexistente");
        }
    }
}

🧱 Paso 4: Importante — Debe enviar TOKEN JWT

Cuando un MS llama a otro MS, TAMBIÉN debe enviar un Authorization header.

No puede dejar endpoints sin seguridad.

Entonces:

HttpHeaders headers = new HttpHeaders();
headers.setBearerAuth(tokenActual); // <-- el token JWT del usuario

HttpEntity<Void> entity = new HttpEntity<>(headers);

ResponseEntity<UsuarioDTO> resp =
        restTemplate.exchange(
            BASE_URL + "/empleado/" + id,
            HttpMethod.GET,
            entity,
            UsuarioDTO.class
        );


✔ De esta manera logística actúa en nombre del usuario real
✔ El profesor lo pide como “propagación de seguridad entre microservicios”.







Comandos:

./mvnw clean                compila
./mvnw spring-boot:run      runea 

desde api gateway: (ya están invalidos a menos que te verifiques con el token)
http://localhost:8080/gestion-comercial/test
http://localhost:8080/gestion-logistica/test
http://localhost:8080/gestion-usuario/test


desde cada ms: 
http://localhost:8081/gestion-comercial/test
http://localhost:8082/gestion-logistica/test
http://localhost:8083/gestion-usuario/test

docker/keycloak:

http://localhost:8180/
usuario: admin
contraseña: admin


docker compose down         bajar el docker
docker compose up -d        levantar el docker

docker ps                   corroborar los procesos


Roles:
admin admin
cliente cliente
empleado empleado







COMO CREAR UN NUEVO USUARIO (Entrar en la carpeta cliente o empleado segun corresponda)
Endpoint 1: solo se utiliza la primera vez: obtener el token de administrador: 
Para poder crear usuarios y asignar roles en Keycloak necesitás un access token de un client con permisos de administration realm.


Endpoint 2: crear el usuario nuevo, tenes que modificar los datos del body porque sino te va a decir que no podes crear un usuario que ya está creado

Endpoint 3: buscar el usuario recien creado para obtener el id, tenes que modificar el get y poner el nuevo username  

Endpoint 4: obtener el rol cliente, no hay que cambiar nada
pero si obtener el roleid

Endpoint 5: asignar ese rol al usuario: en el endpoint modificas el userid que obtuviste en el endpoint 3, y en el body pones el roleid

(opcional)Endpoint 6: cambias el userid en el get para verificar que tenga ese rol

forma de comprobarlo: 
en el localhost:8180 entras con admin admin, tiras f5 en los users y ya aparece






