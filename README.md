MS_Estudiante
Este componente es el encargado de centralizar y gestionar todo el ciclo de vida de la información personal, académica y de contacto de los alumnos dentro de la plataforma.

Especificaciones Técnicas
Puerto: 8001

Base de Datos (Laragon): estudiantes_db

Tecnologías: Spring Boot 3.4.1, Spring Data JPA, MySQL, Springdoc OpenAPI (Swagger), JUnit 5, Mockito

Responsabilidades Principales
Registro, actualización y consulta de alumnos mediante su RUT. Controla el estado de la matrícula (VIGENTE, SUSPENDIDO, EGRESADO) y provee la información base del alumno de forma síncrona a los servicios de Inscripciones, Calificaciones y Arancel.

Estructura de Desarrollo y Pruebas
Estructura de Carpetas: Configuración global de Swagger bajo el paquete config. Pruebas unitarias organizadas en las carpetas controller y service dentro del directorio src/test/java/SigueTuCarrera/.

Carga Inicial: Archivo SQL configurado al lado de application.properties utilizando sentencias INSERT IGNORE INTO.

Endpoints Principales
GET /estudiantes/{rut} - Obtener el perfil completo de un estudiante.

POST /auth/estudiantes - Registrar un nuevo alumno en el sistema.

PUT /auth/estudiantes/{rut} - Actualizar datos de contacto o estado.

GET /swagger-ui.html - Documentación interactiva de la API.

Compilación y Despliegue Docker
Bash
mvn clean package
docker build -t ms-estudiante:1.0 .
docker run -d -p 8001:8001 --name ms-estudiante -e SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:
