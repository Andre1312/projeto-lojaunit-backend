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
	@GeneratedValue(strategy=GenerationType.IDENTITY) //AUTO Mysql -> IDENTITY Postgresql
	@Getter @Setter private Integer id;
	
	@Column(name="datahora", nullable=false)
	@Getter @Setter private Date datahora;
	
	@Column(name="texto", nullable=false)
	@Getter @Setter private String texto;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="id_produto", nullable = false)
	@Getter @Setter private Faq faq;
	
	
	
}
