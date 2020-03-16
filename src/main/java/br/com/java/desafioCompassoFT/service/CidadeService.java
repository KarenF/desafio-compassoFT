package br.com.java.desafioCompassoFT.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.java.desafioCompassoFT.entity.Cidade;

@Service
public interface CidadeService {

	Cidade save(Cidade cidade);
	
	List<Cidade> findAll();
	
	Cidade findById(Long id);
	
	Cidade findByNomeCidade(String nomeCidade);
	
	List<Cidade> findByNomeCidadeContainingIgnoreCase(String nomeCidade);
	
	List<Cidade> findByEstadoContainingIgnoreCase(String estado);
}
