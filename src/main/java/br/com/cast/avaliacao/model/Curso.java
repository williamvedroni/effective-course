package br.com.cast.avaliacao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Curso implements Serializable {

    private static final long serialVersionUID = -5960139357757306808L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Descrição obrigatória.")
    private String descricao;

    @NotNull(message = "Data de início obrigatória.")
    @Temporal(TemporalType.DATE)
    private Date inicio;

    @NotNull(message = "Data de término obrigatória.")
    @Temporal(TemporalType.DATE)
    private Date termino;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    @NotNull(message = "Categoria obrigatória.")
    private Categoria categoria;

    private Long alunos;

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

    /**
     * Método get do atributo inicio
     *
     * @return O valor do atributo inicio
     */
    public Date getInicio() {
        return inicio;
    }

    /**
     * Método set do atributo inicio
     *
     * @param inicio Valor para setar no atributo inicio
     */
    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    /**
     * Método get do atributo termino
     *
     * @return O valor do atributo termino
     */
    public Date getTermino() {
        return termino;
    }

    /**
     * Método set do atributo termino
     *
     * @param termino Valor para setar no atributo termino
     */
    public void setTermino(Date termino) {
        this.termino = termino;
    }

    /**
     * Método get do atributo alunos
     *
     * @return O valor do atributo alunos
     */
    public Long getAlunos() {
        return alunos;
    }

    /**
     * Método set do atributo alunos
     *
     * @param alunos Valor para setar no atributo alunos
     */
    public void setAlunos(Long alunos) {
        this.alunos = alunos;
    }

    /**
     * Método get do atributo categoria
     *
     * @return O valor do atributo categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Método set do atributo categoria
     *
     * @param categoria Valor para setar no atributo categoria
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
