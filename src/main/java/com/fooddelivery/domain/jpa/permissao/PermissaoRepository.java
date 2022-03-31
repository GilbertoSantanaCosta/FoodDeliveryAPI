package com.fooddelivery.domain.jpa.permissao;

import java.util.List;

import com.fooddelivery.domain.model.Permissao;

public interface PermissaoRepository {

	List<Permissao> Listar (Permissao permissao);
	Permissao salvar (Permissao permissao);
	Permissao buscar (Long id);
	void remover (Long id);
	
}
