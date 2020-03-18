package br.com.java.desafioCompassoFT.service.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
		return this.clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> findAll() {
		return this.clienteRepository.findAll();
	}

	@Override
	public Cliente findById(Long id) {
		return this.clienteRepository.findById(id).get();
	}

	@Override
	public List<Cliente> findByNomeClienteContainingIgnoreCase(String nomeCliente) {
		return this.clienteRepository.findByNomeClienteContainingIgnoreCase(nomeCliente);
	}

	@Override
	public String findByIdade(LocalDateTime dataNascimento) throws Exception {

		LocalDateTime now = LocalDateTime.now();
		LocalDateTime tempDateTime = LocalDateTime.from(dataNascimento);
		String idade;

		if (dataNascimento.isAfter(now)) {
			idade = "Ainda não nasceu";
			return idade;
		}

		long anos = tempDateTime.until(now, ChronoUnit.YEARS);
		tempDateTime = tempDateTime.plusYears(anos);
		long meses = tempDateTime.until(now, ChronoUnit.MONTHS);
		tempDateTime = tempDateTime.plusMonths(meses);
		long dias = tempDateTime.until(now, ChronoUnit.DAYS);

		idade = anos + " anos " + meses + " meses e " + dias + " dias";

		return idade;
	}

//	@Override
//	public List<Cliente> findByAtivo(List<Cliente> clientes) {
//
//		List<Cliente> clientesInativos = null;
//		for (int i = 0; i <= clientes.size(); i++) {
//
//		}
//
//		return clientesInativos;
//	}

	@Override
	public void delete(Cliente cliente) {
		this.clienteRepository.delete(cliente);
	}
}
