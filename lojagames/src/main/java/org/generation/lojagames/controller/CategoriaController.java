package org.generation.lojagames.controller;

import java.util.List;
import org.generation.lojagames.model.Categoria;
import org.generation.lojagames.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CategoriaController {
	
	
	@Autowired//
	private CategoriaRepository categoriaRepository;
	
	@GetMapping /*Tem que falar o metodo*/
	public ResponseEntity<List<Categoria>>getAll(){//esta selecionado da tabele categoria
		return ResponseEntity.ok(categoriaRepository.findAll()); //http 200
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable long id) {
		return categoriaRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build()); 
	}
	
	@GetMapping("/genero/{genero}")
	public ResponseEntity<List<Categoria>> GetByCategoria(@PathVariable String genero){
		return ResponseEntity.ok(categoriaRepository.findAllByGeneroContainingIgnoreCase(genero));
							
	}


	@PostMapping
	public ResponseEntity<Categoria> postCategoria(@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria)); // HTTP 201
	
	}
	
	@PutMapping
	public ResponseEntity<Categoria> putCategoria (@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria)); // HTTP 201
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable long id) {
		categoriaRepository.deleteById(id);
		
	}
}
