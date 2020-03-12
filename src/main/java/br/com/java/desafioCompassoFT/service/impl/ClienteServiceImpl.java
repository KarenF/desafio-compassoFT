package br.com.java.desafioCompassoFT.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.java.desafioCompassoFT.entity.Cidades;
import br.com.java.desafioCompassoFT.entity.Cliente;
import br.com.java.desafioCompassoFT.repository.ClienteRepository;
import br.com.java.desafioCompassoFT.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public Cliente save(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> findAll() {
		return this.clienteRepository.findAll();
	}

	@Override
	public Cliente findByIdCliente(Long idCliente) {
		return this.clienteRepository.findByIdCliente(idCliente);
	}

	@Override
	public List<Cliente> findByNomeClienteContainingIgnoreCase(String nomeCliente) {
		return this.clienteRepository.findByNomeClienteContainingIgnoreCase(nomeCliente);
	}

	@Override
	public String findByIdade(LocalDate dataNascimento) throws Exception {

		LocalDate now = LocalDate.now();
		String idade;
		
		if(dataNascimento.isAfter(now)) {
			idade = "Ainda não nasceu";
			return idade;
		}
		
		Period diff = Period.between(dataNascimento, now);
		idade = diff.getYears() + " anos " + diff.getMonths() + " meses e " + diff.getDays() + " dias";

		return idade;
	}

	@Override
	public List<Cliente> findByCidades(Cidades cidades) {
		return this.clienteRepository.findByCidades(cidades);
	}

	@Override
	public void delete(Cliente cliente) {
		this.clienteRepository.delete(cliente);
	}

	@Override
	public Cliente findById(Long id) {
		return this.clienteRepository.findById(id).get(); 
	}
}
