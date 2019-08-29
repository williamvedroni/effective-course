/**
 * Cielo S.A.
 * Projeto BoB
 * Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cast.avaliacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.avaliacao.model.Categoria;
import br.com.cast.avaliacao.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    @Autowired
    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }
}
