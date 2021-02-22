package com.tw.TesteSpringMavem;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tw.TesteSpringMavem.domain.Categoria;
import com.tw.TesteSpringMavem.domain.Cidade;
import com.tw.TesteSpringMavem.domain.Estado;
import com.tw.TesteSpringMavem.domain.Produto;
import com.tw.TesteSpringMavem.repositories.CategoriaRepository;
import com.tw.TesteSpringMavem.repositories.CidadeRepository;
import com.tw.TesteSpringMavem.repositories.EstadoRepository;
import com.tw.TesteSpringMavem.repositories.ProdutoRepository;

@SpringBootApplication
public class TesteSpringMavemApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository iCategoriaRepository;
	@Autowired
	private ProdutoRepository iProdutoRepository;
	@Autowired
	private EstadoRepository iEstadoRepository;
	@Autowired
	private CidadeRepository iCidadeRepository;

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

		// inserindo as relações de produtos e categorias
		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoria2.getProdutos().addAll(Arrays.asList(produto2));

		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));

		Estado estado1 = new Estado(null, "Minas gerai");
		Estado estado2 = new Estado(null, "São Paulo");

		Cidade cidade1 = new Cidade(null, "Uberlãndia", estado1);
		Cidade cidade2 = new Cidade(null, "São Paulo", estado2);
		Cidade cidade3 = new Cidade(null, "Campinas", estado2);

		// iCategoriaRepository.save(Arrays.asList(categoria1, categoria2)); //old
		// version
		iCategoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		iProdutoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));

		
		
		// inserindo as relações de cidades e produtos
		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
		
		iEstadoRepository.saveAll(Arrays.asList(estado1, estado2));
		iCidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));

	}

}
