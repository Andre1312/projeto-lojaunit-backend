package com.prjlojaunitandrebarros.mvc.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="forma_pagamento")
public class FormaPagamento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //AUTO Mysql -> IDENTITY Postgresql
	@Column(name="id")
	@Getter @Setter private Integer idFpg;
	
	@Column(name="forma", nullable = false)
	@Getter @Setter private String forma;
	
	@Column(name="descricao")
	@Getter @Setter private String descricao;
	
	@Column(name="ativo", nullable = false)
	@Getter @Setter private Boolean ativo;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="formaPagamento",cascade=CascadeType.ALL)
	@Getter @Setter private List<Vendas> vendas = new ArrayList<>();
	
}
