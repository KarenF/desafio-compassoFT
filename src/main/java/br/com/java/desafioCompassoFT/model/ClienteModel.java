package br.com.java.desafioCompassoFT.model;

import java.time.LocalDate;

import br.com.java.desafioCompassoFT.entity.Cidades;
import lombok.Data;

@Data
public class ClienteModel {

	private Long idCliente;
	private String nomeCliente;
	private String genero;
	private LocalDate dataNascimento;
	private String idade;

	private Cidades cidades;

}
