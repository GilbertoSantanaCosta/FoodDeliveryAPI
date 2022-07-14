package com.fooddelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fooddelivery.exception.EntidadeNaoEncontradaException;
import com.fooddelivery.model.Cidade;
import com.fooddelivery.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> findAll(){
		
		return cidadeRepository.findAll();
	}
	
	public Cidade findById(Long id) {
		
		return cidadeRepository.findById(id).orElse(null);
	}
	
	public Cidade save(Cidade cidade) {
		
		return cidadeRepository.save(cidade);
	}
	
	public void delete(Long id) {
		
		try {
			cidadeRepository.deleteById(id);
			
		} catch (RuntimeException e) {
			
			throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de estado com o codigo %d ", id));
		}
			
		
		
		
	}
	
	
}
