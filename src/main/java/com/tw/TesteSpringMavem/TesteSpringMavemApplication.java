package com.tw.TesteSpringMavem;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tw.TesteSpringMavem.domain.Categoria;
import com.tw.TesteSpringMavem.domain.Produto;
import com.tw.TesteSpringMavem.repositories.CategoriaRepository;
import com.tw.TesteSpringMavem.repositories.ProdutoRepository;

@SpringBootApplication
public class TesteSpringMavemApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository iCategoriaRepository;
	@Autowired
	private ProdutoRepository iProdutoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TesteSpringMavemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Instanciado tabelas no DB com os objetos abaixo:

		Categoria categoria1 = new Categoria(null, "Informática");
		Categoria categoria2 = new Categoria(null, "Escritório");

		Produto produto1 = new Produto(null, "Computador", 2000.00);
		Produto produto2 = new Produto(null, "Impressora", 800.00);
		Produto produto3 = new Produto(null, "Mouse", 80.00);

		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria2.getProdutos().addAll(Arrays.asList(produto2));

		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));

		// iCategoriaRepository.save(Arrays.asList(categoria1, categoria2)); //old
		// version
		iCategoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		iProdutoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));

	}

}
