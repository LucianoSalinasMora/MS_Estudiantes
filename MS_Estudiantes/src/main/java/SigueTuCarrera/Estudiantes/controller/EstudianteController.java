package SigueTuCarrera.Estudiantes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SigueTuCarrera.Estudiantes.model.Estudiantes;
import SigueTuCarrera.Estudiantes.service.EstudianteService;

@RestController
@RequestMapping("/api/v1/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    @GetMapping
    public ResponseEntity<List<Estudiantes>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{rut}")
    public ResponseEntity<Estudiantes> getByRut(@PathVariable String rut) {
        Estudiantes e = service.findByRut(rut);
        return e != null 
            ? ResponseEntity.ok(e) 
            : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Estudiantes> create(@RequestBody Estudiantes estudiantes) {
        return ResponseEntity.ok(service.save(estudiantes));
    }

    @PutMapping("/{rut}")
    public ResponseEntity<Estudiantes> update(@PathVariable String rut, @RequestBody Estudiantes detalles) {
        Estudiantes e = service.findByRut(rut);
        if (e != null) {

            e.setNombres(detalles.getNombres());
            e.setApellidos(detalles.getApellidos()); 
            e.setEmail(detalles.getEmail());
            return ResponseEntity.ok(service.save(e));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{rut}")
    public ResponseEntity<Void> delete(@PathVariable String rut) {
        Estudiantes e = service.findByRut(rut);
        if (e != null) {
            service.deleteByRut(rut);
        }
        return e != null 
            ? ResponseEntity.noContent().build() 
            : ResponseEntity.notFound().build();
    }
}
