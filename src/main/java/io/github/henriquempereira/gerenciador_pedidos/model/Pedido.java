package io.github.henriquempereira.gerenciador_pedidos.model;

import jakarta.persistence.*;

import java.time.LocalDate;

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

    protected Pedido() {}

    /**
     * Cria um novo pedido pronto para ser persistido
     * @param data Data do horário do pedido
     */
    public Pedido(LocalDate data) {
        this.data = data;
    }

    /**
     * Getter e Setters
     */
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
