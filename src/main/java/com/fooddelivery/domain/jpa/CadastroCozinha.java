package com.fooddelivery.domain.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fooddelivery.domain.model.Cozinha;

@Component
public class CadastroCozinha {

	@PersistenceContext // pode ser usado o Autowired
	private EntityManager manager;
	
	public List<Cozinha> listar(){
		
		return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
	}
	
	public Cozinha buscarPorId() {
		
		return manager.find(Cozinha.class, 1l);
	}
	
	@Transactional
	public Cozinha adicionar(Cozinha cozinha) {
		
		return manager.merge(cozinha);
	}
	
	@Transactional
	public void delete(Long id) {
		
		Cozinha c = manager.find(Cozinha.class, 1l);
		manager.remove(c);
		System.out.println(c.getNome() + " deletada ");
		 
	}
}
