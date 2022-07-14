package com.fooddelivery.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fooddelivery.exception.EntidadeEmUsoException;
import com.fooddelivery.exception.EntidadeNaoEncontradaException;
import com.fooddelivery.model.Cozinha;
import com.fooddelivery.repository.CozinhaRepository;
import com.fooddelivery.service.CozinhaService;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	@Autowired
	private CozinhaService cadastroCozinha;

	@GetMapping
	public List<Cozinha> listar() {

		return cadastroCozinha.findAll();
	}

	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> findById(@PathVariable Long cozinhaId) {

		Cozinha c = cadastroCozinha.findById(cozinhaId);

		if (c != null) {

			return ResponseEntity.ok().body(c);
		}

		return ResponseEntity.notFound().build();

	}
	
	@PostMapping
	public ResponseEntity<Cozinha> save(@RequestBody Cozinha cozinha) {
		
		Cozinha c = cadastroCozinha.save(cozinha);
		
		return ResponseEntity.created(null).body(c);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Cozinha> atualizar(@RequestBody Cozinha cozinha , @PathVariable Long id) {

		Cozinha c = cozinhaRepository.findById(id).orElse(null);

		if (c != null) {
			BeanUtils.copyProperties(cozinha, c, "id");

			cadastroCozinha.save(c);
			
			return ResponseEntity.ok(c);
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> delete(@PathVariable Long cozinhaId) {
		
		try {
			cadastroCozinha.remover(cozinhaId);

			 return ResponseEntity.noContent().build();
		}catch(EntidadeEmUsoException e) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}catch(EntidadeNaoEncontradaException e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
