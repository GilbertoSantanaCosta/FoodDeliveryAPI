package com.fooddelivery.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fooddelivery.api.model.CozinhaXmlWrapper;
import com.fooddelivery.domain.jpa.cozinha.CozinhaRepository;
import com.fooddelivery.domain.model.Cozinha;


@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@GetMapping
	public List<Cozinha> listar(){
		
		return cozinhaRepository.Listar();
	}
	
	
	@GetMapping(produces = org.springframework.http.MediaType.APPLICATION_XML_VALUE)
	public CozinhaXmlWrapper listarWrapperXml(){
		
		return new CozinhaXmlWrapper(cozinhaRepository.Listar());
	}
	
	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
		
		Cozinha c = cozinhaRepository.buscar(cozinhaId);
		
		if(c != null) {
			
			return ResponseEntity.ok().body(c);
		}
		
		return ResponseEntity.notFound().build();
 		
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void adicionar(@RequestBody Cozinha cozinha) {
		
		cozinhaRepository.salvar(cozinha);
	}
	
	@PutMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId){
		return null;
	}
	
	
}
