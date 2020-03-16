package br.com.java.desafioCompassoFT.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.java.desafioCompassoFT.entity.Cidade;
import br.com.java.desafioCompassoFT.repository.CidadeRepository;
import br.com.java.desafioCompassoFT.service.CidadeService;

@Service
public class CidadeServiceImpl implements CidadeService {
	
	@Autowired
	CidadeRepository cidadeRepository;

	@Override
	public Cidade save(Cidade cidades) {
		return this.cidadeRepository.save(cidades);
	}

	@Override
	public List<Cidade> findAll() {
		return this.cidadeRepository.findAll();
	}

	@Override
	public Cidade findById(Long id) {
		return this.cidadeRepository.findById(id).get(); 
	}
	
	@Override
	public Cidade findByNomeCidade(String nomeCidade) {
		return this.cidadeRepository.findByNomeCidade(nomeCidade);
	}

	@Override
	public List<Cidade> findByEstadoContainingIgnoreCase(String estado) {
		return this.cidadeRepository.findByEstadoContainingIgnoreCase(estado);
	}

	@Override
	public List<Cidade> findByNomeCidadeContainingIgnoreCase(String nomeCidade) {
		return this.cidadeRepository.findByNomeCidadeContainingIgnoreCase(nomeCidade);
	}
}
