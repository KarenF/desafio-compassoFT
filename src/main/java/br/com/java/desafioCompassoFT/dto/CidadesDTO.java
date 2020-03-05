package br.com.java.desafioCompassoFT.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.java.desafioCompassoFT.entity.Cliente;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CidadesDTO {

	private Long id;
	@NotBlank
	@Length(min = 2, max = 50, message = "O nome da cidade deve conter entre 2 e 50 caracteres")
	private String nomeCidade;
	@NotBlank
	@Length(min = 2, max = 50, message = "O nome do estado deve conter entre 2 e 50 caracteres")
	private String estado;
	
	private List<Cliente> cliente;
}
