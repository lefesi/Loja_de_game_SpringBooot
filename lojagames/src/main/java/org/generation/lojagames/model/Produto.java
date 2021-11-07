package org.generation.lojagames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")

public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_produto;
	
	@NotBlank (message = "O valor não pode ser nulo e nem pode conter espaço")
	@Size (min = 4, max = 100, message = "Digite no mínimo 4 caractere e no máximo 100")
	private String titulo;
	
	@NotBlank (message = "O valor não pode ser nulo e nem pode conter espaço")
	private double precos;//se for falar de números o notblnk não funciona, tem que ser o notnull
	
	
	@ManyToOne // N:1 esse indica a relação das tabelas, são muitas categorais para 1 produto, a chave estrangeira.
	@JsonIgnoreProperties("categoria") // inpede que ignora campos, por exemplo no select que repetia tudo da tabela, com esse 
	//mostra apenas o que vc seleciona, como no select.
	@JoinColumn(name = "fk_id_categoria")
	private Categoria fk_categoria; //categoria é o nome do atributo e Categoria o nome da classe
	


	

	public Categoria getFk_categoria() {
		return fk_categoria;
	}

	public void setFk_categoria(Categoria fk_categoria) {
		this.fk_categoria = fk_categoria;
	}

	public long getId_produto() {
		return id_produto;
	}

	public void setId_produto(long id_produto) {
		this.id_produto = id_produto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPrecos() {
		return precos;
	}

	public void setPrecos(double precos) {
		this.precos = precos;
	}

}
