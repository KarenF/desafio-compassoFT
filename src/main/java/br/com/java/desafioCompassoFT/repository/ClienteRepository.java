package br.com.java.desafioCompassoFT.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.java.desafioCompassoFT.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Cliente findByIdCliente(Long idCliente);

	Cliente findByNomeCliente(String nome);
}
