package br.com.java.desafioCompassoFT.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.java.desafioCompassoFT.entity.Cidades;

@Service
public interface CidadesService {

	Cidades save(Cidades cidades);
	
	List<Cidades> findAll();
	
	Cidades findById(Long id);
	
	Cidades findByNomeCidade(String nomeCidade);
	
	List<Cidades> findByNomeCidadeLike(String nomeCidade);
	
	List<Cidades> findByEstadoLike(String estado);
}
