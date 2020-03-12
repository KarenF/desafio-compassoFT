package br.com.java.desafioCompassoFT.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.java.desafioCompassoFT.entity.Cidades;
import br.com.java.desafioCompassoFT.entity.Cliente;

@Service
public interface ClienteService {

	Cliente save(Cliente cliente);
	
	List<Cliente> findAll();
	
	Cliente findById(Long id); 
	
	Cliente findByIdCliente(Long idCliente);
	
	List<Cliente> findByNomeClienteContainingIgnoreCase(String nomeCliente);
	
	String findByIdade(LocalDate dataNascimento) throws Exception;
	
	List<Cliente> findByCidades(Cidades cidades);
	
	void delete(Cliente cliente);
}
