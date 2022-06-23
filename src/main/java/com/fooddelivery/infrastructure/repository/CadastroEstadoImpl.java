package com.fooddelivery.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.fooddelivery.domain.jpa.estado.cidade.EstadoRepository;
import com.fooddelivery.domain.model.Estado;


@Component
public class CadastroEstadoImpl implements EstadoRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Estado> Listar() {
		
		return manager.createQuery("from Estado", Estado.class).getResultList();
	}

	@Override
	@Transactional
	public Estado salvar(Estado estado) {
		
		return manager.merge(estado);
	}

	@Override
	public Estado buscar(Long id) {
		
		return manager.find(Estado.class, id);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		
		Estado c = manager.find(Estado.class, id);
		manager.remove(c);
		System.out.println(c.getNome() + " deletada ");
	}

}
