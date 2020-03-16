package br.com.java.desafioCompassoFT.model;

import java.util.List;

import br.com.java.desafioCompassoFT.entity.Cidade;
import br.com.java.desafioCompassoFT.entity.Cliente;

public class IndexModel {

	List<Cidade> cidades;
	List<Cliente> clientes;
	
	public List<Cidade> getCidades() {
		return cidades;
	}
	
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
