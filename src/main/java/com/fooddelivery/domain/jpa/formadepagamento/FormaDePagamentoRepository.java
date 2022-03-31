package com.fooddelivery.domain.jpa.formadepagamento;

import java.util.List;

import com.fooddelivery.domain.model.FormaDePagamento;

public interface FormaDePagamentoRepository {

	List<FormaDePagamento> listar();
	FormaDePagamento buscar(Long id);
	FormaDePagamento salvar(FormaDePagamento formaPagamento);
	void remover(Long id);
}
