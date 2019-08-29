/**
 * Cielo S.A.
 * Projeto BoB
 * Dir Desenvolvimento de Sistemas Bob-O50013375
 *
 * Copyright 2014
 */
package br.com.cast.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.cast.avaliacao.model.Categoria;

@RepositoryRestResource
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
