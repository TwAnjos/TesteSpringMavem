package com.tw.TesteSpringMavem;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tw.TesteSpringMavem.domain.Categoria;
import com.tw.TesteSpringMavem.domain.Cidade;
import com.tw.TesteSpringMavem.domain.Cliente;
import com.tw.TesteSpringMavem.domain.Endereco;
import com.tw.TesteSpringMavem.domain.Estado;
import com.tw.TesteSpringMavem.domain.Produto;
import com.tw.TesteSpringMavem.enums.TipoCliente;
import com.tw.TesteSpringMavem.repositories.CategoriaRepository;
import com.tw.TesteSpringMavem.repositories.CidadeRepository;
import com.tw.TesteSpringMavem.repositories.ClienteRepository;
import com.tw.TesteSpringMavem.repositories.EnderecoRepository;
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
	@Autowired
	private ClienteRepository iClienteRepository;
	@Autowired
	private EnderecoRepository iEnderecoRepository;
	

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
		
		
		//populando clientes
		Cliente cliente1 = new Cliente(null, "Maria Sila", "maria@gmail.com","3637789123777", TipoCliente.PESSOAFISICA);
		//esse cliente tem 2 telefones, então faz assim
		cliente1.getTelefones().addAll(Arrays.asList("277363323","93838393"));
		Endereco endereco1Cliente1 = new Endereco(null, "Rua flores","300","apto 303", "Jardim","38220834", cliente1, cidade1);
		Endereco endereco2Cliente1 = new Endereco(null, "Avenida Matos","105","Sala 800", "Centro","38777012", cliente1, cidade2);
		cliente1.getEnderecos().addAll(Arrays.asList(endereco1Cliente1, endereco2Cliente1));
		iClienteRepository.saveAll(Arrays.asList(cliente1));
		iEnderecoRepository.saveAll(Arrays.asList(endereco1Cliente1, endereco2Cliente1));
		
	}

}
