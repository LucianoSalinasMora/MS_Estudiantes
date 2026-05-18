package SigueTuCarrera.Estudiantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SigueTuCarrera.Estudiantes.model.Estudiantes;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiantes,String>{
    
}
