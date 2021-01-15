package com.prjlojaunitandrebarros.mvc.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="fornecedor")
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter private Integer id;
	
	@Column(name="nome", nullable = false)
	@Getter @Setter private String nome;
	
	@Getter @Setter private String endereco;
	
	@Getter @Setter private String telefone;
	
	@Column(name="cnpj", nullable = false, unique=true)
	@Getter @Setter private String cnpj;
	
	@Getter @Setter private String email;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Produto> produtos = new ArrayList<>();
	

}
