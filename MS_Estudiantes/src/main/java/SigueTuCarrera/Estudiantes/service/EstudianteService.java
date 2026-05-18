package SigueTuCarrera.Estudiantes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SigueTuCarrera.Estudiantes.model.Estudiantes;
import SigueTuCarrera.Estudiantes.repository.EstudianteRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EstudianteService {

    @Autowired
    private EstudianteRepository repository;

    public List<Estudiantes> findAll() {
        return repository.findAll();
    }

    public Estudiantes save(Estudiantes estudiante) {
        return repository.save(estudiante);
    }

    public Estudiantes findByRut(String rut) {
        return repository.findById(rut).orElse(null);
    }

    public void deleteByRut(String rut) {
        Estudiantes estudiante = findByRut(rut);
        if (estudiante != null) {
            repository.delete(estudiante);
        }
    }
}
