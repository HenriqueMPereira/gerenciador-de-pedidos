package io.github.henriquempereira.gerenciador_pedidos.model;

import jakarta.persistence.*;

/**
 * Representa os parceiros comerciais do sistema.
 * Mantém o registro das empresas que fornecem os insumos e produtos para venda.
 */
@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String nome;

    // Construtor padrão exigido pelo Hibernate/JPA
    protected Fornecedor() {}

    /**
     * Cria um novo fornecedor para o sistema.
     * @param nome Nome do fornecedor.
     */
    public Fornecedor(String nome) {
        this.nome = nome;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
