package com.springproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.domain.Cliente;
import com.springproject.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente retornaCliente(Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.orElse(null);
	}
}
