package br.com.java.desafioCompassoFT.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.java.desafioCompassoFT.entity.Cidades;
import br.com.java.desafioCompassoFT.repository.CidadesRepository;
import br.com.java.desafioCompassoFT.service.CidadesService;

@Service
public class CidadesServiceImpl implements CidadesService {
	
	@Autowired
	CidadesRepository cidadesRepository;

	@Override
	public Cidades save(Cidades cidades) {
		return cidadesRepository.save(cidades);
	}

	@Override
	public List<Cidades> findAll() {
		return cidadesRepository.findAll();
	}

	@Override
	public Cidades findById(Long id) {
		return this.cidadesRepository.findById(id).get(); 
	}
	
	@Override
	public Cidades findByNomeCidade(String nomeCidade) {
		return cidadesRepository.findByNomeCidade(nomeCidade);
	}

	@Override
	public List<Cidades> findByNomeCidadeLike(String nomeCidade) {
		return cidadesRepository.findByNomeCidadeLike("%"+nomeCidade+"%");
	}

	@Override
	public List<Cidades> findByEstadoLike(String estado) {
		return cidadesRepository.findByEstadoLike("%"+estado+"%");
	}
}
