package slzfood.domain.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(name = "taxa_frete", nullable = false)
	private BigDecimal taxaFrete;

	//@JsonIgnore
	//@JsonIgnoreProperties("hibernateLazyInitializer")
	@ManyToOne //(fetch = FetchType.LAZY)
	@JoinColumn(name = "cozinha_id", nullable = false)
	private Cozinha cozinha;
	

	@JsonIgnore
	@Embedded
	private Endereco endereco;

	@JsonIgnore
	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "datetime")
	private LocalDateTime dataCadastro;

	@JsonIgnore
	@UpdateTimestamp
	@Column(nullable = false, columnDefinition = "datetime")
	private LocalDateTime dataAtualizacao;
 
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "restaurante_forma_pagamento", 
			joinColumns = @JoinColumn(name = "restaurante_id"),
			inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
	private List<FormaPagamento> formasPagamento = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "restaurante")
	private List<Produto> produtos = new ArrayList<>();
	

    @Enumerated(EnumType.STRING)
    private StatusRestaurante status;
    
    public void ativar() {
		setStatus(StatusRestaurante.ATIVO);
	}

	public void inativar() {
		setStatus(StatusRestaurante.INATIVO);
	}

	public void abrir() {
		setStatus(StatusRestaurante.ABERTO);
	}

	public void fechar() {
		setStatus(StatusRestaurante.FECHADO);
	}

	public boolean isAtivo() {
		return getStatus() == StatusRestaurante.ATIVO;
	}

	public boolean isInativo() {
		return getStatus() == StatusRestaurante.INATIVO;
	}

	public boolean isAberto() {
		return getStatus() == StatusRestaurante.ABERTO;
	}

	public boolean isFechado() {
		return getStatus() == StatusRestaurante.FECHADO;
	}

}
