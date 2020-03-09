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
	public List<Cidades> findByNomeCidade(String nomeCidade) {
		return cidadesRepository.findByNomeCidade(nomeCidade);
	}

	@Override
	public List<Cidades> findByEstado(String estado) {
		return cidadesRepository.findByEstado(estado);
	}
}
