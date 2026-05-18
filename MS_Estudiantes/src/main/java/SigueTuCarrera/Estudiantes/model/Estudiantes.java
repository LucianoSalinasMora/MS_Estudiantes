package SigueTuCarrera.Estudiantes.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Estudiantes {
    @Id
    private String rut;
    
    private String nombres;
    private String apellidos;
    private String email;
    private String telefono;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;
    private String direccion;
    
    @Enumerated(EnumType.STRING)
    private EstadoMatricula estadoMatricula;

    public enum EstadoMatricula {
        VIGENTE, SUSPENDIDO, RETIRADO, EGRESADO
    }
}
