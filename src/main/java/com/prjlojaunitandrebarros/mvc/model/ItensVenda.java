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
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_venda", nullable = false)
	private Vendas vendas;
		
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_produto", nullable = false)
	private Produto produto;
	
	@Getter @Setter private Integer quantidade;
	
	@Column(name="valor_unitario")
	@Getter @Setter private Double valorUnitario;

}
