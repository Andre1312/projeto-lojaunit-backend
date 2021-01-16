package com.prjlojaunitandrebarros.mvc.model;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="vendas")
public class Vendas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter private Integer id;
	
	@Getter @Setter private Date datahora;
			
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_cliente", nullable = false)
	@Getter @Setter private Clientes clientes;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_forma_pagamento", nullable = false)
	@Getter @Setter private FormaPagamento formaPagamento;
	
	@Column(name="valor_total")
	@Getter @Setter private Double valorTotal;
	
	@OneToMany(mappedBy="vendas",cascade=CascadeType.ALL)
	@Getter @Setter private List<ItensVenda> itensVenda = new ArrayList<>();
	
	

}
