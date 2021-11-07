package org.generation.lojagames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity//é uma entidade do tipo tabela
@Table(name= "tb_categoria") //é uma entidade do tipo tabela

public class Categoria {
	
	@Id//automaticamente ja ssbe que é a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_categoria;
	
	@NotBlank (message = "O valor não pode ser nulo e nem pode conter espaço")
	@Size (min = 1, max = 20, message = "Digite no mínimo 1 caractere e no máximo 20")
	private String plataforma;
	
	@NotBlank (message = "O valor não pode ser nulo e nem pode conter espaço")
	@Size (min = 2, max = 50, message = "Digite no mínimo 2 caractere e no máximo 50")
	private String genero; 
	
	@NotBlank (message = "O valor não pode ser nulo e nem pode conter espaço")
	@Size (min = 1, max = 50, message = "Digite no mínimo 1 caractere e no máximo 50")
	private String condicao;

	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)//cascate: tudo que vc faz em uma tabela ele faz na outra.
	//mappedBy é de onde ele irá tirar os dados que é de uma categoria especifica.
    @JsonIgnoreProperties("categoria")
    private List<Produto> produto;//cria uma lista de Produtoss com o nome de produto, ele ira trazer o produto
	
	
	
	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCondicao() {
		return condicao;
	}

	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}
	
	
	
	
	
}
