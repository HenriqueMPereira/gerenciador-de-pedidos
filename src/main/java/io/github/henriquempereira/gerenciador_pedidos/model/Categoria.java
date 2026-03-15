package io.github.henriquempereira.gerenciador_pedidos.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Produto> listaDeProdutos = new ArrayList<>();

    // Construtor padrão exigido pelo JPA
    protected Categoria() {}

    /**
     * Cria uma nova categora pronto para ser persistida.
     * @param nome  Nome descritivo da categoria.
     */
    public Categoria(String nome) {
        this.nome = nome;
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Adiciona um produto à categoria, garantindo a sincronização bidirecional.
     * @param produto Produto a ser inserido.
     */
    public void adicionarProduto(Produto produto) {
        listaDeProdutos.add(produto);      // O pai reconhece o filho
        produto.setCategoria(this); // O filho reconhece o pai
    }

    /**
     * Remove um produto da categoria e desfaz o vínculo bidirecional.
     * @param produto Produto a ser removido.
     */
    public void removerProduto(Produto produto) {
        listaDeProdutos.remove(produto);
        produto.setCategoria(null);
    }
}
