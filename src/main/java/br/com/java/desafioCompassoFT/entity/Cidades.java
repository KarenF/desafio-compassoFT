package br.com.java.desafioCompassoFT.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Cidades implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5076998331643312343L;

	private Long id;
	private String nomeCidade;
	private String estado;
	
	private List<Cliente> cliente;
}
