package com.fooddelivery.domain.jpa;

import java.util.List;

import com.fooddelivery.domain.model.Restaurante;

public interface RestauranteRepository {

	 List<Restaurante>listar();
	 Restaurante buscar (Long id);
	 Restaurante salvar(Restaurante restaurante);
	 void remover(Long id); 
}
