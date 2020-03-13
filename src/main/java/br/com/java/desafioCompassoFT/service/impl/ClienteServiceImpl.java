package br.com.java.desafioCompassoFT.service.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
	public String findByIdade(LocalDateTime dataNascimento) throws Exception {

		LocalDateTime now = LocalDateTime.now();
		String idade;

		if (dataNascimento.isAfter(now)) {
			idade = "Ainda não nasceu";
			return idade;
		}

		long anos = ChronoUnit.YEARS.between(dataNascimento, now);
        long meses = ChronoUnit.MONTHS.between(dataNascimento, now);
        long dias = ChronoUnit.DAYS.between(dataNascimento, now);
		
		idade = anos + " anos " + meses + " meses e " + dias + " dias";

		return idade;
	}

//	@Override
//	public List<Cliente> findByCidades(Cidades cidades) {
//		return this.clienteRepository.findByCidades(cidades);
//	}

	@Override
	public void delete(Cliente cliente) {
		this.clienteRepository.delete(cliente);
	}

	@Override
	public Cliente findById(Long id) {
		return this.clienteRepository.findById(id).get();
	}
}
