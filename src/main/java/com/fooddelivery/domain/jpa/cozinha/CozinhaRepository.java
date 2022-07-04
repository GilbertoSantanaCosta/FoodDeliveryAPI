package com.fooddelivery.domain.jpa.cozinha;

import java.util.List;

import com.fooddelivery.domain.model.Cozinha;

public interface CozinhaRepository {

	List<Cozinha> Listar ();
	List<Cozinha> buscarPorNome(String name);
	Cozinha salvar (Cozinha cozinha);
	Cozinha buscar (Long id);
	void remover (Long id);
	
}
