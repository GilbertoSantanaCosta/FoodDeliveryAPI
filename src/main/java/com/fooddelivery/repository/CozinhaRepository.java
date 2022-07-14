package com.fooddelivery.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fooddelivery.model.Cozinha;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

	
	// List<Cozinha> buscarPorNome(String name);
	
	
}
