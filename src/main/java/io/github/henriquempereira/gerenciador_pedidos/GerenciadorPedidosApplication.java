package io.github.henriquempereira.gerenciador_pedidos;

import io.github.henriquempereira.gerenciador_pedidos.model.Categoria;
import io.github.henriquempereira.gerenciador_pedidos.model.Pedido;
import io.github.henriquempereira.gerenciador_pedidos.model.Produto;
import io.github.henriquempereira.gerenciador_pedidos.repository.CategoriaRepository;
import io.github.henriquempereira.gerenciador_pedidos.repository.PedidoRepository;
import io.github.henriquempereira.gerenciador_pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class GerenciadorPedidosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorPedidosApplication.class, args);
	}

	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	PedidoRepository pedidoRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World!");

		Produto produto1 = new Produto("Cheese Burger", 28.90);
		produtoRepository.save(produto1);

		Categoria categoria1 = new Categoria("Lanches");
		categoriaRepository.save(categoria1);

		LocalDate localDate = LocalDate.of(2026, 03, 11);
		Pedido pedido1 = new Pedido(localDate);
		pedidoRepository.save(pedido1);

	}
}
