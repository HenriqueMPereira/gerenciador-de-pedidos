package io.github.henriquempereira.gerenciador_pedidos.model;

import jakarta.persistence.*;

/**
 * Representa a entidade Categoria do sistema de gerenciamento de pedido
 * Centraliza informação básica da categoria do produto
 */
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    // Construtor padrão exigido pelo JPA
    protected Categoria() {}

    /**
     * Cria uma nova categora pronto para ser persistida.
     * @param nome  Nome descritivo da categoria.
     */
    public Categoria(String nome) {
        this.nome = nome;
    }

    /**
     * Getters e Setters
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
