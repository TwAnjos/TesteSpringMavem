package com.tw.TesteSpringMavem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.TesteSpringMavem.domain.Cliente;
import com.tw.TesteSpringMavem.repositories.ClienteRepository;
import com.tw.TesteSpringMavem.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository iClienteRepository;

	public Cliente getClienteById(Integer id) {

		Optional<Cliente> cliente = iClienteRepository.findById(id);

		if (!cliente.isPresent()) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado. ID: " + id + " - Tipo: " + Cliente.class.getName());
		}

		return cliente.get();
	}
}
