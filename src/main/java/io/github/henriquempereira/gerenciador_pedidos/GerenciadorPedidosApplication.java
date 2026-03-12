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

		Categoria categoria1 = new Categoria("Lanches");
		Categoria categoria2 = new Categoria("Bebidas");

		Produto produto1 = new Produto("Cheese Burger", 27.0);
		Produto produto2 = new Produto("Cheese Salada", 30.0);
		Produto produto3 = new Produto("Coca Cola", 8.0);

		categoria1.adicionarProduto(produto1);
		categoria1.adicionarProduto(produto2);
		categoria2.adicionarProduto(produto3);

		categoriaRepository.save(categoria1);
		categoriaRepository.save(categoria2);

		LocalDate localDate = LocalDate.of(2026, 3, 11);
		Pedido pedido1 = new Pedido(localDate);
		pedidoRepository.save(pedido1);

	}
}
