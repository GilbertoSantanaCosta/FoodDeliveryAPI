package com.fooddelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fooddelivery.model.Permissao;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long>{

	
	
}
