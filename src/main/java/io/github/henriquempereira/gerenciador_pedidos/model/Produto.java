package io.github.henriquempereira.gerenciador_pedidos.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a entidade Produto do sistema de gerenciamento de pedidos.
 * Centraliza as informações básicas de precificação e identificação dos itens vendidos.
 */
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;
    @Column(name = "valor")
    private Double preco;

    @JoinColumn(name = "categoria_id", nullable = false)
    @ManyToOne
    private Categoria categoria;

    @ManyToMany(mappedBy = "listaDeProdutos")
    private List<Pedido> listaDePedidos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    // Construtor padrão exigido pelo JPA.
    protected Produto() {}

    /**
     * Cria um novo produto pronto para ser persistido.
     * @param nome  Nome descritivo do produto (obrigatório e único no sistema).
     * @param preco Valor de venda do produto.
     */
    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

     // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Pedido> getListaDePedidos() {
        return listaDePedidos;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
