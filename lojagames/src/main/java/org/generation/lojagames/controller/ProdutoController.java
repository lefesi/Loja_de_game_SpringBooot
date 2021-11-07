package org.generation.lojagames.controller;

import java.util.List;

import org.generation.lojagames.model.Categoria;
import org.generation.lojagames.model.Produto;
import org.generation.lojagames.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ProdutoController {
	
	@Autowired//
	private CategoriaRepository produtoRepository;
	
	@GetMapping /*Tem que falar o metodo*/
	public ResponseEntity<List<Categoria>> getAll(){//esta selecionado da tabele categoria
		return ResponseEntity.ok(produtoRepository.findAll()); //http 200
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable long id) {
		return produtoRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build()); 
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
							
	}


	@PostMapping
	public ResponseEntity<Produto> postProduto(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto)); // HTTP 201
	
	}
	
	@PutMapping
	public ResponseEntity<Produto> putProduto (@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto)); // HTTP 201
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable long id) {
		produtoRepository.deleteById(id);
		
	}

}
