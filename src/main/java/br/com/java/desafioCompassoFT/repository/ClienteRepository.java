package br.com.java.desafioCompassoFT.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.java.desafioCompassoFT.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	List<Cliente> findByNomeClienteContainingIgnoreCase(String nomeCliente);

	String findByIdade(LocalDateTime dataNascimento);
	
	List<Cliente> findByAtivo(List<Cliente> clientes);
}
