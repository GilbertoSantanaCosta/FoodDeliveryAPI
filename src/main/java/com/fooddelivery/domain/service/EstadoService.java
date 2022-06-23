package com.fooddelivery.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fooddelivery.domain.exception.EntidadeEmUsoException;
import com.fooddelivery.domain.exception.EntidadeNaoEncontradaException;
import com.fooddelivery.domain.jpa.estado.cidade.EstadoRepository;
import com.fooddelivery.domain.model.Estado;

@Service
public class EstadoService {

	@Autowired
	public EstadoRepository estadoRepository;

	public List<Estado> listar() {

		return estadoRepository.Listar();
	}

	public Estado salvar(Estado estado) {

		return estadoRepository.salvar(estado);
	}

	public Estado buscar(Long id) {
		
		
			return estadoRepository.buscar(id);
		
	}

	public void atualizar(Estado estado) {

		Estado estadoTest = estadoRepository.buscar(estado.getId());

		if (estadoTest == null) {

			throw new EntidadeNaoEncontradaException("Estado com o codigo " + estado.getId() + " não cadastrada ");
		}

		estadoRepository.salvar(estado);
	}

	public void delete(Long id) {
		try {
			estadoRepository.remover(id);
		} catch (EmptyResultDataAccessException e) {
			
			throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de estado com o codigo %d ", id));
		}catch (IllegalArgumentException e) {
			
			throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de estado com o codigo %d ", id));
		}
	}

}
