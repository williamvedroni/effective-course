/**
 * Cielo S.A.
 * Projeto BoB
 * Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cast.avaliacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.avaliacao.exception.BusinessException;
import br.com.cast.avaliacao.exception.Mensagens;
import br.com.cast.avaliacao.model.Curso;
import br.com.cast.avaliacao.repository.CursoRepository;

@Service
public class CursoService {

    private final CursoRepository repository;

    @Autowired
    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public List<Curso> findAll() {
        return repository.findAll();
    }

    public Optional<Curso> findById(Long id) {
        return repository.findById(id);
    }

    public Curso save(Curso curso) {
        this.validate(curso);
        return repository.save(curso);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Curso> findByName(String nome){

        return repository.findByName(nome);
    }

    private void validate(Curso curso) {
        validarDataIncial(curso);
        validarPeriodoConflitante(curso);
    }

    private void validarDataIncial(Curso curso) {
        if (curso.getInicio().after(curso.getTermino())) {
            throw BusinessException.of(Mensagens.MSG_DATA_INVALIDA);
        }
    }

    private void validarPeriodoConflitante(Curso curso) {

        final List<Curso> cursos = repository.findInRange(curso.getInicio(), curso.getTermino());

        for (Curso c : cursos) {
            if (curso.getId() != null && !curso.getId().equals(c.getId())) {
                throw BusinessException.of(Mensagens.MSG_PERIODO_CONFLITANTE);
            }
        }

    }
}
