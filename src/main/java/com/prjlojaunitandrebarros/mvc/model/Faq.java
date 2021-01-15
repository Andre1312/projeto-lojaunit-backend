package com.prjlojaunitandrebarros.mvc.model;

import lombok.*;

import javax.persistence.*;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="faq")
public class Faq {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter private Integer id;
	
	@Column(name="datahora", nullable=false)
	@Getter @Setter private Date datahora;
	
	@Column(name="texto", nullable=false)
	@Getter @Setter private String texto;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_produto", nullable = false)
	private Faq faq;
	
	
	
}
