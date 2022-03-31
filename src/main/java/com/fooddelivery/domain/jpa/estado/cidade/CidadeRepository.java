package com.fooddelivery.domain.jpa.estado.cidade;

import java.util.List;

import com.fooddelivery.domain.model.Cidade;


public interface CidadeRepository {

	List<Cidade> Listar (Cidade cidade);
	Cidade salvar (Cidade cidade);
	Cidade buscar (Long id);
	void remover (Long id);
	
}
