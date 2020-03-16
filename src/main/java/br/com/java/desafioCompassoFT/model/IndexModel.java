package br.com.java.desafioCompassoFT.model;

import java.util.List;

import br.com.java.desafioCompassoFT.entity.Cidades;
import br.com.java.desafioCompassoFT.entity.Cliente;

public class IndexModel {

	List<Cidades> cidades;
	List<Cliente> clientes;
	
	public List<Cidades> getCidades() {
		return cidades;
	}
	
	public void setCidades(List<Cidades> cidades) {
		this.cidades = cidades;
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
