package SigueTuCarrera.Estudiantes.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import SigueTuCarrera.Estudiantes.model.Estudiantes;
import SigueTuCarrera.Estudiantes.service.EstudianteService;

@WebMvcTest(EstudianteController.class)
public class EstudianteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EstudianteService service;

    @Test
    void testGetByRutNotFound() throws Exception {
        when(service.findByRut("11111111-1")).thenReturn(null);

        mockMvc.perform(get("/api/v1/estudiantes/11111111-1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreateEstudiante() throws Exception {
        Estudiantes estudiante = new Estudiantes();
        when(service.save(any(Estudiantes.class))).thenReturn(estudiante);

        mockMvc.perform(post("/api/v1/estudiantes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombres\":\"Juan\",\"apellidos\":\"Pérez\",\"email\":\"juan@mail.com\"}"))
                .andExpect(status().isOk());
    }
}