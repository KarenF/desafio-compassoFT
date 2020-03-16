package br.com.java.desafioCompassoFT.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.java.desafioCompassoFT.entity.Cidades;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDTO {

	private Long idCliente;
	@NotBlank
	@Length(min = 3, max = 50, message = "O nome do convidado deve conter entre 3 e 50 caracteres")
	private String nomeCliente;
	@NotBlank
	@Length(min = 1, max = 50, message = "O gênero deve conter entre 1 e 50 caracteres")
	private String genero;
	private LocalDate dataNascimento;
	private int idade;

	private Cidades cidades;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Cidades getCidades() {
		return cidades;
	}

	public void setCidades(Cidades cidades) {
		this.cidades = cidades;
	}
}
