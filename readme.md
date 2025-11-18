To do:
requerimientos dentro de cada ms 


verificar que cada requerimiento funcione con y solo con:
@PreAuthorize("hasRole('rol')")


API Client interno entre microservicios


google maps


detalladamente:



# 🟨 *FASE 5 — API Client interno entre microservicios (Apunte 18)*

El proyecto requiere que unas llamadas sean *microservicio → microservicio* usando RestTemplate/WebClient:

Ejemplos del TPI:

* Logística consulta Usuarios para validar un chofer
* Comercial consulta Usuarios para validar cliente
* Logística consulta Comercial para obtener contenedores
* Etc.

Debemos agregar un *cliente REST* configurado como Bean:

java
@Bean
public RestTemplate restTemplate() {
   return new RestTemplate();
}


Y luego:

java
restTemplate.getForObject("http://localhost:8081/gestion-comercial/...", DTO.class)


---

# 🟫 *FASE 6 — Google Distance API (solo ms-logística)*

El TPI pide:

✔ Logística debe llamar a *Google Distance Matrix API*
✔ Debe calcular distancia entre depósitos

Se usa WebClient o RestTemplate.

Necesita:

* API Key
* Endpoint GET
* Parse del JSON
* Devolver distancia en km

---


# 🟪 *FASE 8 — Dockerización (Apunte 22 y 23)*

Dockerizar:

* ms-usuario
* ms-comercial
* ms-logistica
* api-gateway
* keycloak

Y crear un docker-compose.yml global.





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
