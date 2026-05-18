# MS_Estudiante
Este componente es el encargado de centralizar y gestionar todo el ciclo de vida de la información personal, académica y de contacto de los alumnos dentro de la plataforma.

## Especificaciones Técnicas
* **Puerto:** `8001`
* **Base de Datos (Laragon):** `estudiantes_db`
* **Tecnologías:** Spring Boot 4.0.6, Spring Data JPA, MySQL

## Responsabilidades Principales
* Registro, actualización y consulta de alumnos mediante su RUT.
* Control del estado de la matrícula (VIGENTE, SUSPENDIDO, EGRESADO).
* Proveer la información base del alumno de forma síncrona a los servicios de Inscripciones, Calificaciones y Arancel.

## Endpoints Principales
* `GET /api/v1/estudiantes/{rut}` - Obtener el perfil completo de un estudiante.
* `POST /api/v1/estudiantes` - Registrar un nuevo alumno en el sistema.
* `PUT /api/v1/estudiantes/{rut}` - Actualizar datos de contacto o estado.
