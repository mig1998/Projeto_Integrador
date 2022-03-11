package org.unidas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unidas.model.Postagem;
import org.unidas.repository.PostagemRepository;

@RestController

@RequestMapping(value = "/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class PostagemController {

	@Autowired
	private PostagemRepository repository;

//	gettar requisicao
	@GetMapping
	public ResponseEntity<List<Postagem>> findAllPostagem() {
		return ResponseEntity.ok(repository.findAll());

	}

//	pegar pelo id. que legal!
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> findByIdPostagem(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());

	}

//	pegar pelo titulo. que legal!
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> findByDescricaoTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));

	}

	//
	@PostMapping
	public ResponseEntity<Postagem> postPostagem(@RequestBody Postagem postagem) {

		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));

	}

	@PutMapping
	public ResponseEntity<Postagem> putPostagem(@RequestBody Postagem postagem) {

		return ResponseEntity.ok(repository.save(postagem));

	}

	@DeleteMapping("/{id}")
	public void deletePostagem(@PathVariable long id) {

		repository.deleteById(id);

	}

}
