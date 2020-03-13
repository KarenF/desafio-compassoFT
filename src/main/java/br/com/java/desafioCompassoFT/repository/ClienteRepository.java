package br.com.java.desafioCompassoFT.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.java.desafioCompassoFT.entity.Cidades;
import br.com.java.desafioCompassoFT.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Cliente findByIdCliente(Long idCliente);

	List<Cliente> findByNomeClienteContainingIgnoreCase(String nomeCliente);

	String findByIdade(LocalDateTime dataNascimento);
	
//	List<Cliente> findByCidades(Cidades cidades);
}
