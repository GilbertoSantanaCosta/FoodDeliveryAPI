package com.fooddelivery.domain.jpa.estado.cidade;

import java.util.List;

import com.fooddelivery.domain.model.Estado;




public interface EstadoRepository {

	List<Estado> Listar (Estado Estado);
	Estado salvar (Estado Estado);
	Estado buscar (Long id);
	void remover (Long id);
	
}
