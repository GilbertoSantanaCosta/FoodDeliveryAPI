package com.fooddelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fooddelivery.exception.EntidadeNaoEncontradaException;
import com.fooddelivery.model.Cozinha;
import com.fooddelivery.model.Restaurante;
import com.fooddelivery.repository.CozinhaRepository;
import com.fooddelivery.repository.RestauranteRepository;

@Service
public class RestauranteService {

	@Autowired
	private RestauranteRepository repository;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public List<Restaurante> findAll(){
		
		return repository.findAll();
	}
	public Restaurante findById(Long id) {
		
		Restaurante restaurante =  repository.findById(id).orElse(null);
		
		return restaurante;
	}
	
	public void save(Restaurante restaurante) {
		Long id = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.findById(restaurante.getCozinha().getId()).get();
		
		if(cozinha == null) {
			throw new EntidadeNaoEncontradaException("Cozinha com o codigo " + id + " não cadastrada " );
		}
		
		repository.save(restaurante);
	}
	
	public void update(Restaurante restaurante) {
		
		
		Long idRestaurante = restaurante.getId();
		Restaurante buscaRestaurante = repository.findById(idRestaurante).orElse(null);
		
		Long idCozinha = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.findById(restaurante.getCozinha().getId()).orElse(null);
		
		if(buscaRestaurante != null) {
			repository.save(restaurante);
		}else {
			throw new EntidadeNaoEncontradaException("Restaurante com o codigo " + idRestaurante + " não cadastrada " );
		}
		
		if(cozinha == null) {
			throw new EntidadeNaoEncontradaException("Cozinha com o codigo " + idCozinha + " não cadastrada " );
		}
	}
	
	public void delete(Long id) {
		
		try {
			repository.deleteById(id);
		} catch (RuntimeException e) {
			throw new EntidadeNaoEncontradaException("Restaurante com o codigo " + id + " não cadastrada " );
		}
	}
}
