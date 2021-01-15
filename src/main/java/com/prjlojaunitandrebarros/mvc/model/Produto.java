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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter private Integer id;
	
	@Getter @Setter private String nome;
	@Getter @Setter private String descricao;
	
	@Column(name="preco_unitario")
	@Getter @Setter private Double precoUnitario;
	
	@Getter @Setter private String unidade;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_categoria", nullable = false)
	private Categoria categoria;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_fornecedor", nullable = false)
	private Fornecedor fornecedor;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_marca", nullable = false)
	private Marcas marcas;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Faq> faqs = new ArrayList<>();

	@OneToMany(cascade=CascadeType.ALL)
	private List<ItensVenda> itensvendas= new ArrayList<>();
	
}
