package SigueTuCarrera.Estudiantes.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import SigueTuCarrera.Estudiantes.model.Estudiantes;
import SigueTuCarrera.Estudiantes.repository.EstudianteRepository;

@ExtendWith(MockitoExtension.class)
public class EstudianteServiceTest {

    @Mock
    private EstudianteRepository repository;

    @InjectMocks
    private EstudianteService service;

    @Test
    void testFindByRutExitoso() {
        Estudiantes estudiante = new Estudiantes();
        when(repository.findById("12345678-9")).thenReturn(Optional.of(estudiante));

        Estudiantes resultado = service.findByRut("12345678-9");
        assertNotNull(resultado);
    }

    @Test
    void testDeleteByRut() {
        Estudiantes estudiante = new Estudiantes();
        // Simular que primero lo encuentra para poder borrarlo según tu lógica
        when(repository.findById("12345678-9")).thenReturn(Optional.of(estudiante));

        service.deleteByRut("12345678-9");
        verify(repository, times(1)).delete(estudiante);
    }
}