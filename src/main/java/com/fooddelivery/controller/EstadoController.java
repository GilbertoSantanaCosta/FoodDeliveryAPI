package com.fooddelivery.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
import com.fooddelivery.model.Estado;
import com.fooddelivery.repository.EstadoRepository;
import com.fooddelivery.service.EstadoService;

@RestController                    // Padroniza para a classe o formato de envio 
@RequestMapping(value = "/estados")//produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
public class EstadoController {

	@Autowired
	private EstadoService estadoService;
	
	// passa envio em json e xml
	@GetMapping(produces = { org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			org.springframework.http.MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Estado>>  findAll() {

		List<Estado> estados = estadoService.findAll();
		return ResponseEntity.ok(estados);
	}

	/*
	// envia apenas em json 
	@GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public List<Estado> listar2() {

		return estadoRepository.Listar();
	}
	*/
	
	@GetMapping("/{id}")
	public ResponseEntity<Estado> findById(@PathVariable Long id) {
		
		Estado estado = estadoService.findById(id);
		
		if(estado == null){
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(estado);
	}
	
	@PostMapping
	public ResponseEntity<Estado> save(@RequestBody Estado estado){
		
		 Estado e = estadoService.save(estado);
		
		return ResponseEntity.created(null).body(e);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Estado> updade(@PathVariable Long id, @RequestBody Estado estado){
		
		Estado estadoTest = estadoService.findById(id);
		estado.setId(id);
		if(estadoTest == null){
			return ResponseEntity.notFound().build();
		}
		Estado e = estadoService.save(estado);
		return ResponseEntity.ok().body(e);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Estado> remove(@PathVariable Long id){
		
		try {
			estadoService.delete(id);

			 return ResponseEntity.noContent().build();
		}catch(EntidadeNaoEncontradaException e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		 	
	}
 
}
