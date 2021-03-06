package com.fooddelivery.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fooddelivery.exception.EntidadeNaoEncontradaException;
import com.fooddelivery.model.Restaurante;
import com.fooddelivery.service.RestauranteService;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

	@Autowired
	private RestauranteService restauranteService;

	@GetMapping
	public List<Restaurante> findAll() {

		return restauranteService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Restaurante> findById(@PathVariable Long id) {

		Restaurante restaurante = restauranteService.findById(id);
		
		if(restaurante == null) {
			
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().body(restaurante);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Restaurante restaurante) {

		try {
			restauranteService.save(restaurante);

			return ResponseEntity.created(null).build();
		} catch (EntidadeNaoEncontradaException e) {

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Restaurante restaurante){
		
		Restaurante res = restaurante;
		res.setId(id);
		
		try {
			restauranteService.update(res);
			
			return ResponseEntity.created(null).build();
		} catch (EntidadeNaoEncontradaException e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<?> atualizarParcial(@PathVariable Long id, @RequestBody Map<String , Object> campos){
		
		Restaurante restaurante = restauranteService.findById(id);
		
		if (restaurante == null) {
			
			return ResponseEntity.notFound().build();
		}
		
		merge(campos, restaurante);
		
		return update(id, restaurante);
		
	}
	
	public void merge(Map<String , Object> campos , Restaurante restauranteDestino) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		Restaurante restauranteOrigem = objectMapper.convertValue(campos, Restaurante.class);
		
		campos.forEach((nomePropriedade, valorPropriedade) -> {
			Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
			field.setAccessible(true);
			
			Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);
			
			ReflectionUtils.setField(field, restauranteDestino, novoValor);
			
		});
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		try {
			restauranteService.delete(id);
			return ResponseEntity.ok(null);
		
		} catch (EntidadeNaoEncontradaException e) {
			
			return ((BodyBuilder) ResponseEntity.notFound()).body(e.getMessage());
		}
	}
	
	
}
