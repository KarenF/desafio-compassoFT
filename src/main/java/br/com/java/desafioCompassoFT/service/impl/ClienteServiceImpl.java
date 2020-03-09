package br.com.java.desafioCompassoFT.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.java.desafioCompassoFT.entity.Cliente;
import br.com.java.desafioCompassoFT.repository.ClienteRepository;
import br.com.java.desafioCompassoFT.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente findByIdCliente(Long idCliente) {
		return clienteRepository.findByIdCliente(idCliente);
	}

	@Override
	public List<Cliente> findByNomeCliente(String nome) {
		return clienteRepository.findByNomeCliente(nome);
	}

	@Override
	public String findByIdade(String dataNascimento) throws Exception {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(dataNascimento, formatter);

		LocalDate now = LocalDate.now();
		Period diff = Period.between(localDate, now);
		String idade = diff.getYears() + " anos " + diff.getMonths() + " meses e " + diff.getDays() + " dias";

		return idade;
	}

	@Override
	public void delete(Cliente cliente) {
		clienteRepository.delete(cliente);
	}
}
