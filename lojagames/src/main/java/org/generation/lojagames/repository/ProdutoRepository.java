package org.generation.lojagames.repository;

import java.util.List;


import org.generation.lojagames.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {//entidade igual da model, logo Produto, e 
	//onde esta o ID  é o tipo do dado em maiusculo
	
	public List<Produto> findAllByNomeContainingIgnoreCase (String nome);

	
	
}
