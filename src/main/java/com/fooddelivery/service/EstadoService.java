package com.fooddelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import com.fooddelivery.exception.EntidadeNaoEncontradaException;
import com.fooddelivery.model.Estado;
import com.fooddelivery.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	public EstadoRepository estadoRepository;

	public List<Estado> findAll() {

		return estadoRepository.findAll();
	}

	public Estado save(Estado estado) {

		return estadoRepository.save(estado);
	}

	public Estado findById(Long id) {
		
		
			return estadoRepository.findById(id).orElse(null);
		
	}

	public void update(Estado estado) {

		Estado estadoTest = estadoRepository.findById(estado.getId()).orElse(null);

		if (estadoTest == null) {

			throw new EntidadeNaoEncontradaException("Estado com o codigo " + estado.getId() + " não cadastrada ");
		}

		estadoRepository.save(estado);
	}

	public void delete(Long id) {
		try {
			estadoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			
			throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de estado com o codigo %d ", id));
		}catch (IllegalArgumentException e) {
			
			throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de estado com o codigo %d ", id));
		}
	}

}
