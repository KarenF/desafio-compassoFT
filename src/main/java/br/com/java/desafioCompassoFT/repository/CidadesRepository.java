package br.com.java.desafioCompassoFT.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.java.desafioCompassoFT.entity.Cidades;

public interface CidadesRepository extends JpaRepository<Cidades, Long> {

	Cidades findByNomeCidade(String nomeCidade);

	Cidades findByEstado(String estado);
}
