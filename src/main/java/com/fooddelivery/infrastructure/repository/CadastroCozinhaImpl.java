package com.fooddelivery.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fooddelivery.domain.jpa.cozinha.CozinhaRepository;
import com.fooddelivery.domain.model.Cozinha;

@Repository
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
		
		return manager.find(Cozinha.class, id);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		Cozinha c = buscar(id);
		
		if(c == null) {
			
			throw new EmptyResultDataAccessException(1);
		}
		
		manager.remove(c);
		
	}

	@Override
	public List<Cozinha> buscarPorNome(String name) {
		
		return manager.createQuery("from Cozinha where nome like :nome", Cozinha.class)
					  .setParameter("nome","%" + name + "%")
					  .getResultList();
	}

}
