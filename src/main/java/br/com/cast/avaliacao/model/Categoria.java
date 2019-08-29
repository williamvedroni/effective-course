package br.com.cast.avaliacao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categoria implements Serializable {

    private static final long serialVersionUID = -69032378508153957L;

    @Id
    private Long id;

    private String descricao;

    /**
     * Método get do atributo id
     *
     * @return O valor do atributo id
     */
    public Long getId() {
        return id;
    }

    /**
     * Método set do atributo id
     *
     * @param id Valor para setar no atributo id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método get do atributo descricao
     *
     * @return O valor do atributo descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Método set do atributo descricao
     *
     * @param descricao Valor para setar no atributo descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
