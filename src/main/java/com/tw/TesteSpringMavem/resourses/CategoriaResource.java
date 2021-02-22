package com.tw.TesteSpringMavem.resourses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tw.TesteSpringMavem.domain.Categoria;
import com.tw.TesteSpringMavem.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired /* pra nao precisar fazer injecao manual */
	private CategoriaService categoriaService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Categoria categoria = categoriaService.getCategoriaById(id);
		
		//return ResponseEntity.ok(categoria);
		return ResponseEntity.ok().body(categoria);
		
	}
	
	

	@RequestMapping(value="/tw", method = RequestMethod.GET)
	public List<Categoria> twListar() {
		
		Categoria cat1 = new Categoria(1, "Informatica");
		Categoria cat2 = new Categoria(2, "Escritório");
		
		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		
		return lista;
	}
}
