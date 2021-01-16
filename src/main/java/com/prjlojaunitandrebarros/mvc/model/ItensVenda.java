package com.prjlojaunitandrebarros.mvc.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="itens_venda")
public class ItensVenda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="id_venda", nullable = false)
	@Getter @Setter private Vendas vendas;
		
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="id_produto", nullable = false)
	@Getter @Setter private Produto produto;
	
	@Getter @Setter private Integer quantidade;
	
	@Column(name="valor_unitario")
	@Getter @Setter private Double valorUnitario;

}
