package io.github.henriquempereira.gerenciador_pedidos.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa a entidade Pedido do sistema de gerenciamento de pedido
 * Centraliza as informações básicas de um pedido
 */
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private LocalDate data;

    @ManyToMany
    @JoinTable(name = "pedido_produto",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> listaDeProdutos = new ArrayList<>();

    // Construtor padrão pedido pelo Hibernate/JPA
    protected Pedido() {}

    /**
     * Cria um novo pedido pronto para ser persistido
     * @param data Data do horário do pedido
     */
    public Pedido(LocalDate data) {
        this.data = data;
    }

    //Getter e Setters

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    /**
     * Adiciona um produto ao pedido, garantindo a sincronização bidirecional.
     * @param produto Produto a ser inserido.
     */
    public void adicionaProdutoNoPedido(Produto produto) {
        this.listaDeProdutos.add(produto);
        produto.getListaDePedidos().add(this);
    }

    /**
     * Remove um produto do pedido e desfaz o vínculo bidirecional.
     * @param produto Produto a ser removido.
     */
    public void removeProdutoNoPedido(Produto produto) {
        this.listaDeProdutos.remove(produto);
        produto.getListaDePedidos().remove(this);
    }
}
