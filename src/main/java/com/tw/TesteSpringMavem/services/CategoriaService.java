package com.tw.TesteSpringMavem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.TesteSpringMavem.domain.Categoria;
import com.tw.TesteSpringMavem.repositories.CategoriaRepository;
import com.tw.TesteSpringMavem.services.exceptions.ObjectNotFoundException;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository iCategoriaRepository;

	public Categoria getCategoriaById(Integer id) {

		Optional<Categoria> categoria = iCategoriaRepository.findById(id);

		if (!categoria.isPresent()) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado. ID: " + id + " - Tipo: " + Categoria.class.getName());
		}

		return categoria.get();
	}
}
