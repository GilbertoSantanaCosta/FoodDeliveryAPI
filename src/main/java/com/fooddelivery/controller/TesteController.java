package com.fooddelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fooddelivery.model.Cozinha;
import com.fooddelivery.repository.CozinhaRepository;

@RestController
@RequestMapping("/test")
public class TesteController {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@GetMapping("/buscaPorNome")
	public List<Cozinha> buscaPorNome(@RequestParam String nome){
		
		return null;//cozinhaRepository.buscarPorNome(nome);
	}
	
}
