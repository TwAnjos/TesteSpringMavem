package com.tw.TesteSpringMavem;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tw.TesteSpringMavem.domain.Categoria;
import com.tw.TesteSpringMavem.repositories.CategoriaRepository;

@SpringBootApplication
public class TesteSpringMavemApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository iCategoriaRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(TesteSpringMavemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria(null, "Informática");
		Categoria categoria2 = new Categoria(null, "Escritório");
		
		//iCategoriaRepository.save(Arrays.asList(categoria1, categoria2)); //old version
		iCategoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		
	}

}
