package com.prjlojaunitandrebarros.mvc.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="marcas")
public class Marcas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO Mysql -> IDENTITY Postgresql
	@Getter @Setter private Integer id;
	
	@Getter @Setter private String nome;
	@Getter @Setter private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="marcas",cascade=CascadeType.ALL)
	@Getter @Setter private List<Produto> produtos = new ArrayList<>();
	
	
}
