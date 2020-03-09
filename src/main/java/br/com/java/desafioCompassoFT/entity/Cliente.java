package br.com.java.desafioCompassoFT.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@Column(nullable = false)
	private String dataNascimento;
	private String idade;

	@JoinColumn(name = "cidades", referencedColumnName = "id", updatable = false, nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Cidades cidades;
}
