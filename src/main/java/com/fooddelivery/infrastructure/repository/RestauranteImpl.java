package com.fooddelivery.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fooddelivery.domain.jpa.cozinha.CozinhaRepository;
import com.fooddelivery.domain.jpa.restaurante.RestauranteRepository;
import com.fooddelivery.domain.model.Cozinha;
import com.fooddelivery.domain.model.Restaurante;

@Component
public class RestauranteImpl implements RestauranteRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Restaurante> listar() {
		
		return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
	}

	@Override
	@Transactional
	public Restaurante salvar(Restaurante restaurante) {
		
		return manager.merge(restaurante);
	}

	@Override
	public Restaurante buscar(Long id) {
		
		return manager.find(Restaurante.class, id);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		
		Restaurante r = manager.find(Restaurante.class, 1l);
		manager.remove(r);
		System.out.println(r.getNome() + " deletada ");
	}

}
