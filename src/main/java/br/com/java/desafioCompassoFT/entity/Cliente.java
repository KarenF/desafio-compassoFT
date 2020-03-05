package br.com.java.desafioCompassoFT.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -648906708267780745L;

	private Long id;
	private String nomeCliente;
	private String genero;
	private String dataNascimento;
	private int idade;
	
	private Cidades cidades;
}
