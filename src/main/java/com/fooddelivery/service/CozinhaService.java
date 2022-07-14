package com.fooddelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fooddelivery.exception.EntidadeEmUsoException;
import com.fooddelivery.exception.EntidadeNaoEncontradaException;
import com.fooddelivery.model.Cozinha;
import com.fooddelivery.repository.CozinhaRepository;

@Service
public class CozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public List<Cozinha> findAll(){
		
		return cozinhaRepository.findAll();
	}
	
	public Cozinha save(Cozinha cozinha) {
		
		return cozinhaRepository.save(cozinha);
	}
	
    public Cozinha findById(Long id) {
		
    	// Metodo findById retorna um optional por isso usamos o .get para retornar a instancia do objeto desejado 
		return cozinhaRepository.findById(id).orElse(null);
	}
    
    public void remover(Long id) {
		try {
			cozinhaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(
					String.format("Cozinha de codigo %d não pode ser removido", id));
		} catch(EmptyResultDataAccessException e) {
			
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cozinha com o codigo %d ", id));
		}
		
	}
    
    
}
