package br.com.java.desafioCompassoFT.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.java.desafioCompassoFT.entity.Cidades;

public interface CidadesRepository extends JpaRepository<Cidades, Long> {
	
	Optional<Cidades> findById(Long id);
	
	Cidades findByNomeCidade(String nomeCidade);

	List<Cidades> findByNomeCidadeLike(String nomeCidade);

	List<Cidades> findByEstadoLike(String estado);
}
