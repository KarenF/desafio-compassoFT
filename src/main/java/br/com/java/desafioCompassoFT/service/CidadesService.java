package br.com.java.desafioCompassoFT.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.java.desafioCompassoFT.entity.Cidades;

@Service
public interface CidadesService {

	Cidades save(Cidades cidades);
	
	List<Cidades> findAll();
	
	List<Cidades> findByNomeCidade(String nomeCidade);
	
	Cidades findByEstado(String estado);
}
