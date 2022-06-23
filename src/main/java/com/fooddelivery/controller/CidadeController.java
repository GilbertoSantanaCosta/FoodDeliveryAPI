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

import com.fooddelivery.domain.exception.EntidadeNaoEncontradaException;
import com.fooddelivery.domain.model.Cidade;
import com.fooddelivery.domain.service.CidadeService;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping
	public ResponseEntity<List<Cidade>> listar(){
		
		List<Cidade> cidades = cidadeService.listar();
		return ResponseEntity.ok().body(cidades);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cidade> listar(@PathVariable Long id){
		
	    Cidade cidade = cidadeService.buscar(id);
		return ResponseEntity.ok().body(cidade);
	}
	
	@PostMapping
	public ResponseEntity<Cidade> salvar(@RequestBody Cidade cidade){
		
		Cidade cidadeSalva = cidadeService.salvar(cidade);
		
		return ResponseEntity.ok().body(cidadeSalva);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cidade> atualizar(@PathVariable Long id, @RequestBody Cidade cidade){
		
		cidade.setId(id);
		cidadeService.salvar(cidade);

		return ResponseEntity.ok().body(cidade);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove(@PathVariable Long id){
		
		try {
			cidadeService.remover(id);
			return ResponseEntity.ok().build();
		
		} catch (EntidadeNaoEncontradaException e) {
			
			return ResponseEntity.notFound().build();
		}
			
		
		
		
	}
	
	

}
