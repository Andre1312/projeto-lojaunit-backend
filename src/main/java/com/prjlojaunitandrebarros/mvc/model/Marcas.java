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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter private Integer id;
	
	@Getter @Setter private String nome;
	@Getter @Setter private String descricao;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Produto> produtos = new ArrayList<>();
	
	
}
