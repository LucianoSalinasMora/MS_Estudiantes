package SigueTuCarrera.Estudiantes.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Schema(description = "Representa la información personal, de contacto y académica de un estudiante matriculado")
public class Estudiantes {

    @Id
    @Schema(
        description = "RUT único del estudiante (sin puntos y con guión, actúa como identificador principal)", 
        example = "20123456-K",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String rut;
    
    @Schema(description = "Nombres del estudiante", example = "Juan Andrés")
    private String nombres;

    @Schema(description = "Apellidos del estudiante", example = "Pérez Cotapo")
    private String apellidos;

    @Schema(description = "Correo electrónico de contacto (institucional o personal)", example = "juan.perez@duocuc.cl")
    private String email;

    @Schema(description = "Número telefónico de contacto móvil o fijo", example = "+56912345678")
    private String telefono;

    @Schema(description = "Fecha de nacimiento del estudiante", example = "2002-05-14")
    private LocalDate fechaNacimiento;

    @Schema(description = "Fecha formal en la que el alumno ingresó a la institución", example = "2024-03-01")
    private LocalDate fechaIngreso;

    @Schema(description = "Dirección residencial actual del estudiante", example = "Av. Concón Reñaca 450, Viña del Mar")
    private String direccion;
    
    @Enumerated(EnumType.STRING)
    @Schema(description = "Estado administrativo de la matrícula del alumno en el periodo vigente", example = "VIGENTE")
    private EstadoMatricula estadoMatricula;

    @Schema(description = "Estados posibles de la matrícula académica")
    public enum EstadoMatricula {
        VIGENTE, SUSPENDIDO, RETIRADO, EGRESADO
    }
}