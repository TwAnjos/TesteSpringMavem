package com.tw.TesteSpringMavem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.TesteSpringMavem.domain.Categoria;
import com.tw.TesteSpringMavem.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository iCategoriaRepository;

	public Categoria getCategoriaById(Integer id) {
		Optional<Categoria> categoria = iCategoriaRepository.findById(id);
		return categoria.orElse(null);
	}
}
