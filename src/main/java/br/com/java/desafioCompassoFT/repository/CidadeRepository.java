package br.com.java.desafioCompassoFT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.java.desafioCompassoFT.entity.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
	Cidade findByNomeCidade(String nomeCidade);

	List<Cidade> findByNomeCidadeContainingIgnoreCase(String nomeCidade);

	List<Cidade> findByEstadoContainingIgnoreCase(String estado);
}
