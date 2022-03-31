package com.fooddelivery.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fooddelivery.domain.jpa.estado.cidade.CidadeRepository;
import com.fooddelivery.domain.model.Cidade;
import com.fooddelivery.domain.model.Cozinha;

@Component
public class CadastroCidadeImpl implements CidadeRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cidade> Listar(Cidade cidade) {
		
		return manager.createQuery("from Cidade", Cidade.class).getResultList();
	}

	@Override
	@Transactional
	public Cidade salvar(Cidade cidade) {
		
		return manager.merge(cidade);
	}

	@Override
	public Cidade buscar(Long id) {
		
		return manager.find(Cidade.class, 1l);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		
		Cidade c = manager.find(Cidade.class, 1l);
		manager.remove(c);
		System.out.println(c.getNome() + " deletada ");
	}

}
