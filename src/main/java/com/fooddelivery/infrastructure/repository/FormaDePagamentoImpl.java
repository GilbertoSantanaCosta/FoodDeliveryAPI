package com.fooddelivery.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fooddelivery.domain.jpa.formadepagamento.FormaDePagamentoRepository;
import com.fooddelivery.domain.model.FormaDePagamento;

@Component
public class FormaDePagamentoImpl implements FormaDePagamentoRepository {

	@PersistenceContext
	private EntityManager manager;
	
	
	@Override
	public List<FormaDePagamento> listar() {
		
		return manager.createQuery("select FormaDePagamento", FormaDePagamento.class).getResultList();
	}
	
	@Override
	@Transactional
	public FormaDePagamento salvar(FormaDePagamento cozinha) {
		
		return manager.merge(cozinha);
	}

	@Override
	public FormaDePagamento buscar(Long id) {
		
		return manager.find(FormaDePagamento.class, 1l);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		
		FormaDePagamento f = manager.find(FormaDePagamento.class, 1l);
		manager.remove(f);
		System.out.println(f.getDescricao() + " deletada ");
	}

	
	}


