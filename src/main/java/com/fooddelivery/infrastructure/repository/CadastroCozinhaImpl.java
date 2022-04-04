package com.fooddelivery.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fooddelivery.domain.jpa.cozinha.CozinhaRepository;
import com.fooddelivery.domain.model.Cozinha;

@Component
public class CadastroCozinhaImpl implements CozinhaRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cozinha> Listar() {
		
		return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
	}

	@Override
	@Transactional
	public Cozinha salvar(Cozinha cozinha) {
		
		return manager.merge(cozinha);
	}

	@Override
	public Cozinha buscar(Long id) {
		
		return manager.find(Cozinha.class, 1l);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		
		Cozinha c = manager.find(Cozinha.class, 1l);
		manager.remove(c);
		System.out.println(c.getNome() + " deletada ");
	}

}
