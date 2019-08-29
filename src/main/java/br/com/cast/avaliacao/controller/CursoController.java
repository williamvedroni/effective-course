package br.com.cast.avaliacao.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.avaliacao.model.Curso;
import br.com.cast.avaliacao.service.CursoService;

@RestController
@RequestMapping(path = "/api/v1/cursos", produces = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "http://localhost:4200")
public class CursoController {

    private final CursoService service;

    @Autowired
    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Curso>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Curso> create(@Valid @RequestBody Curso curso) {
        return ResponseEntity.ok(service.save(curso));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Long id) {

        final Optional<Curso> curso = service.findById(id);

        if (!curso.isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(curso.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable Long id, @Valid @RequestBody Curso curso) {

        final Optional<Curso> c = service.findById(id);

        if (!c.isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(service.save(curso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        final Optional<Curso> curso = service.findById(id);

        if (!curso.isPresent()) {
            ResponseEntity.badRequest().build();
        }

        service.deleteById(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/find")
    public ResponseEntity<List<Curso>> findById(@RequestParam String nome) {

        return ResponseEntity.ok(service.findByName(nome));
    }

}
