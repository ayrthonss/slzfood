package slzfood.domain.model;


import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MapsId;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class ItemPedido {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @EmbeddedId
	private Long id;

	private BigDecimal precoUnitario;
	private BigDecimal precoTotal;
	 @Column(nullable = false)
	private Integer quantidade;
	private String observacao;


    @ManyToOne
    @MapsId("pedidoId")
    @JoinColumn(name = "pedido_id", nullable = false)
	private Pedido pedido;

	@ManyToOne
    @MapsId("produtoId")
	@JoinColumn(name = "produto_id", nullable = false)
	private Produto produto;
    
}

