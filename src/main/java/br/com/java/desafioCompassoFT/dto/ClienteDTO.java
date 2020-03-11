package br.com.java.desafioCompassoFT.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.java.desafioCompassoFT.entity.Cidades;
import lombok.Data;

@Data
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
}
