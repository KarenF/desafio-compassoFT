package br.com.java.desafioCompassoFT.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.java.desafioCompassoFT.entity.Cidade;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDTO {

	private Long id;
	@NotBlank
	@Length(min = 3, max = 50, message = "O nome do convidado deve conter entre 3 e 50 caracteres")
	private String nomeCliente;
	@NotBlank
	@Length(min = 1, max = 50, message = "O gênero deve conter entre 1 e 50 caracteres")
	private String genero;
	private LocalDate dataNascimento;
	private int idade;

	private Cidade cidades;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Cidade getCidades() {
		return cidades;
	}

	public void setCidades(Cidade cidades) {
		this.cidades = cidades;
	}
}
