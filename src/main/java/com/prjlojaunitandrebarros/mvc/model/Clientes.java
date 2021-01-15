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
@Table(name="clientes")
public class Clientes {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter private Integer id;
	
	@Column(name="nome", nullable = false)
	@Getter @Setter private String nome;
	
	@Column(name="cpf", nullable = false, unique=true)
	@Getter @Setter private String cpf;
	
	@Column(name="email", nullable = false)
	@Getter @Setter private String email;
	
	@Column(name="data_nascimento")
	@Getter @Setter private Date dataNascimento;
	
	@Getter @Setter private String sexo;
	
	@Column(name="nome_social")
	@Getter @Setter private String nomeSocial;
	
	@Getter @Setter private String apelido;
	
	@Getter @Setter private String telefone;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Vendas> vendas = new ArrayList<>();
	
	

}
