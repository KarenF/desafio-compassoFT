package br.com.java.desafioCompassoFT.model;

import java.util.List;

import br.com.java.desafioCompassoFT.entity.Cidades;
import br.com.java.desafioCompassoFT.entity.Cliente;
import lombok.Data;

@Data
public class IndexModel {

	List<Cidades> cidades;
	List<Cliente> clientes;
}
