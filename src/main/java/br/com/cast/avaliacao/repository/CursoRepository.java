package br.com.cast.avaliacao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.cast.avaliacao.model.Curso;

@RepositoryRestResource
public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query("select c from Curso c where :inicio between c.inicio and c.termino or :termino between c.inicio and c.termino ")
    List<Curso> findInRange(final @Param("inicio") Date inicio, final @Param("termino") Date termino);

    @Query("select c from Curso c where c.descricao like %:nome% ")
    List<Curso> findByName(final @Param("nome") String nome);
}
