package com.prjlojaunitandrebarros.mvc.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //AUTO Mysql -> IDENTITY Postgresql
	@Getter @Setter private Integer id;
	
	@Getter @Setter private String nome;
	@Getter @Setter private String descricao;
	
	@Column(name="preco_unitario")
	@Getter @Setter private Double precoUnitario;
	
	@Getter @Setter private String unidade;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="id_categoria", nullable = false)
	@Getter @Setter private Categoria categoria;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="id_fornecedor", nullable = false)
	@Getter @Setter private Fornecedor fornecedor;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="id_marca", nullable = false)
	@Getter @Setter private Marcas marcas;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="produto" , cascade=CascadeType.ALL)
	@Getter @Setter private List<Faq> faqs = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy="produto", cascade=CascadeType.ALL)
	@Getter @Setter private List<ItensVenda> itensvendas= new ArrayList<>();
	
}
