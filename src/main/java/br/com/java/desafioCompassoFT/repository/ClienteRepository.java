package br.com.java.desafioCompassoFT.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.java.desafioCompassoFT.entity.Cidades;
import br.com.java.desafioCompassoFT.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Cliente findByIdCliente(Long idCliente);

	List<Cliente> findByNomeClienteLike(String nomeCliente);

	String findByIdade(LocalDate dataNascimento);
	
	List<Cliente> findByCidades(Cidades cidades);
}
