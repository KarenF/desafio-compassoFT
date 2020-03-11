package br.com.java.desafioCompassoFT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.java.desafioCompassoFT.entity.Cidades;

public interface CidadesRepository extends JpaRepository<Cidades, Long> {

	List<Cidades> findByNomeCidadeLike(String nomeCidade);

	List<Cidades> findByEstadoLike(String estado);
}
