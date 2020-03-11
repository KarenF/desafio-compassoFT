package br.com.java.desafioCompassoFT.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -648906708267780745L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCliente", updatable = false, nullable = false)
	private Long idCliente;
	@NotBlank
	@Column(nullable = false)
	private String nomeCliente;
	@NotBlank
	@Column(nullable = false)
	private String genero;
	private LocalDate dataNascimento;
	private String idade;

	private Cidades cidades;
}
