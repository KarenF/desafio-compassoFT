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
		return this.cidadesRepository.save(cidades);
	}

	@Override
	public List<Cidades> findAll() {
		return this.cidadesRepository.findAll();
	}

	@Override
	public Cidades findById(Long id) {
		return this.cidadesRepository.findById(id).get(); 
	}
	
	@Override
	public Cidades findByNomeCidade(String nomeCidade) {
		return this.cidadesRepository.findByNomeCidade(nomeCidade);
	}

	@Override
	public List<Cidades> findByEstadoContainingIgnoreCase(String estado) {
		return this.cidadesRepository.findByEstadoContainingIgnoreCase(estado);
	}

	@Override
	public List<Cidades> findByNomeCidadeContainingIgnoreCase(String nomeCidade) {
		return this.cidadesRepository.findByNomeCidadeContainingIgnoreCase(nomeCidade);
	}
}
