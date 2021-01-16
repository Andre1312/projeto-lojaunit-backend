package com.prjlojaunitandrebarros.mvc.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter private Integer id;
	
	@Getter @Setter private String nome;
	
	@Column(name="ativo", nullable = false)
	@Getter @Setter private Boolean ativo;
	
	@OneToMany(mappedBy="categoria",cascade=CascadeType.ALL)
	@Getter @Setter private List<Produto> produtos = new ArrayList<>();

}
