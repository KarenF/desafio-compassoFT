package br.com.java.desafioCompassoFT.service;

import org.springframework.stereotype.Service;

import br.com.java.desafioCompassoFT.entity.Cidades;
import br.com.java.desafioCompassoFT.entity.Cliente;

@Service
public interface ClienteService {

	Cliente save(Cliente cliente);
	
	Iterable<Cliente> findByCidades(Cidades cidades);
	
	Cliente findByIdCliente(Long idCliente);
	
	Cliente findByNomeCliente(String nome);
	
	void delete(Cliente cliente);
}
