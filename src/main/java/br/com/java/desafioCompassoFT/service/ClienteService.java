package br.com.java.desafioCompassoFT.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.java.desafioCompassoFT.entity.Cliente;

@Service
public interface ClienteService {

	Cliente save(Cliente cliente);
	
	List<Cliente> findAll();
	
	Cliente findByIdCliente(Long idCliente);
	
	Cliente findByNomeCliente(String nome);
	
	void delete(Cliente cliente);
}