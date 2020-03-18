package br.com.java.desafioCompassoFT.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.java.desafioCompassoFT.entity.Cliente;

@Service
public interface ClienteService {

	Cliente save(Cliente cliente);
	
	List<Cliente> findAll();
	
	Cliente findById(Long id); 
	
	List<Cliente> findByNomeClienteContainingIgnoreCase(String nomeCliente);
	
	String findByIdade(LocalDateTime dataNascimento) throws Exception;
	
//	List<Cliente> findByAtivo(List<Cliente> clientes);
	
	void delete(Cliente cliente);
}
