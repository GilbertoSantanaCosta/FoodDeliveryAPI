package com.fooddelivery.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fooddelivery.domain.exception.EntidadeEmUsoException;
import com.fooddelivery.domain.exception.EntidadeNaoEncontradaException;
import com.fooddelivery.domain.jpa.cozinha.CozinhaRepository;
import com.fooddelivery.domain.model.Cozinha;

@Service
public class CadastroCozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Cozinha salvar(Cozinha cozinha) {
		
		return cozinhaRepository.salvar(cozinha);
	}
	
    public Cozinha buscar(Long id) {
		
		return cozinhaRepository.buscar(id);
	}
    
    public void remover(Long id) {
		try {
			cozinhaRepository.remover(id);
		} catch (DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(
					String.format("Cozinha de codigo %d não pode ser removido", id));
		} catch(EmptyResultDataAccessException e) {
			
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cozinha com o codigo %d ", id));
		}
		
	}
    
    
}
