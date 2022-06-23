package com.fooddelivery.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fooddelivery.domain.exception.EntidadeNaoEncontradaException;
import com.fooddelivery.domain.jpa.estado.cidade.CidadeRepository;
import com.fooddelivery.domain.model.Cidade;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> listar(){
		
		return cidadeRepository.listar();
	}
	
	public Cidade buscar(Long id) {
		
		return cidadeRepository.buscar(id);
	}
	
	public Cidade salvar(Cidade cidade) {
		
		return cidadeRepository.salvar(cidade);
	}
	
	public void remover(Long id) {
		
		try {
			cidadeRepository.remover(id);
			
		} catch (IllegalArgumentException e) {
			
			throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de estado com o codigo %d ", id));
		}
			
		
		
		
	}
	
	
}
