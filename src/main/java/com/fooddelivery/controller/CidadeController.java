package com.fooddelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fooddelivery.exception.EntidadeNaoEncontradaException;
import com.fooddelivery.model.Cidade;
import com.fooddelivery.service.CidadeService;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping
	public ResponseEntity<List<Cidade>> findAll(){
		
		List<Cidade> cidades = cidadeService.findAll();
		return ResponseEntity.ok().body(cidades);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cidade> findById(@PathVariable Long id){
		
	    Cidade cidade = cidadeService.findById(id);
	    
	    if(cidade == null) {
			
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(cidade);
	}
	
	@PostMapping
	public ResponseEntity<Cidade> save(@RequestBody Cidade cidade){
		
		Cidade cidadeSalva = cidadeService.save(cidade);
		
		return ResponseEntity.ok().body(cidadeSalva);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cidade> update(@PathVariable Long id, @RequestBody Cidade cidade){
		
		Cidade city = cidadeService.findById(id);
		
		if (city == null) {
			
			ResponseEntity.notFound().build();
		}
		
		cidade.setId(id);
		cidadeService.save(cidade);
		return ResponseEntity.ok().body(cidade);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		try {
			cidadeService.delete(id);
			return ResponseEntity.ok().build();
		
		} catch (EntidadeNaoEncontradaException e) {
			
			return ResponseEntity.notFound().build();
		}
			
		
		
		
	}
	
	

}
