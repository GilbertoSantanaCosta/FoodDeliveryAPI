package com.fooddelivery.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fooddelivery.domain.jpa.permissao.PermissaoRepository;
import com.fooddelivery.domain.model.Permissao;

@Component
public class CadastroPermissaoImpl implements PermissaoRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Permissao> Listar(Permissao permissao) {
		
		return manager.createQuery("from permissao", Permissao.class).getResultList();
	}

	@Override
	@Transactional
	public Permissao salvar(Permissao permissao) {
		
		return manager.merge(permissao);
	}

	@Override
	public Permissao buscar(Long id) {
		
		return manager.find(Permissao.class, 1l);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		
		Permissao p = manager.find(Permissao.class, 1l);
		manager.remove(p);
		System.out.println(p.getNome() + " deletada ");
	}

}
