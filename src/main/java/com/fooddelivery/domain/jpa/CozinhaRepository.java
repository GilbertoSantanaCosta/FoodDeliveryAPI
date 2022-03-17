package com.fooddelivery.domain.jpa;

import java.util.List;

import com.fooddelivery.domain.model.Cozinha;

public interface CozinhaRepository {

	List<Cozinha> Listar (Cozinha cozinha);
	Cozinha salvar (Cozinha cozinha);
	Cozinha buscar (Long id);
	void remover (Long id);
	
}
