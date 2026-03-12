package io.github.henriquempereira.gerenciador_pedidos.repository;

import io.github.henriquempereira.gerenciador_pedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
