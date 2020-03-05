package br.com.java.desafioCompassoFT.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cidades")
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Cidades implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5076998331643312343L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@NotBlank
	@Column(nullable = false)
	private String nomeCidade;
	@NotBlank
	@Column(nullable = false)
	private String estado;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cidades", cascade = CascadeType.ALL)
	private List<Cliente> cliente;
}
