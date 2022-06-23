package com.fooddelivery.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fooddelivery.domain.exception.EntidadeNaoEncontradaException;
import com.fooddelivery.domain.jpa.cozinha.CozinhaRepository;
import com.fooddelivery.domain.jpa.restaurante.RestauranteRepository;
import com.fooddelivery.domain.model.Cozinha;
import com.fooddelivery.domain.model.Restaurante;

@Service
public class RestauranteService {

	@Autowired
	private RestauranteRepository repository;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public List<Restaurante> listar(){
		
		return repository.listar();
	}
	public Restaurante buscar(Long id) {
		
		Restaurante restaurante =  repository.buscar(id);
		
		return restaurante;
	}
	public void salvar(Restaurante restaurante) {
		Long id = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.buscar(restaurante.getCozinha().getId());
		
		if(cozinha == null) {
			throw new EntidadeNaoEncontradaException("Cozinha com o codigo " + id + " não cadastrada " );
		}
		
		repository.salvar(restaurante);
	}
	
	public void atualizar(Restaurante restaurante) {
		
		
		Long idRestaurante = restaurante.getId();
		Restaurante buscaRestaurante = repository.buscar(idRestaurante);
		
		Long idCozinha = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.buscar(restaurante.getCozinha().getId());
		
		
		if(cozinha == null) {
			throw new EntidadeNaoEncontradaException("Cozinha com o codigo " + idCozinha + " não cadastrada " );
		}
		
		if(buscaRestaurante != null) {
			repository.salvar(buscaRestaurante);
		}else {
			throw new EntidadeNaoEncontradaException("Restaurante com o codigo " + idRestaurante + " não cadastrada " );
		}
	}
}
