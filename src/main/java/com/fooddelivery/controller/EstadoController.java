package com.fooddelivery.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fooddelivery.domain.jpa.estado.cidade.EstadoRepository;
import com.fooddelivery.domain.model.Estado;

@RestController                    // Padroniza para a classe o formato de envio 
@RequestMapping(value = "/estados")//produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;
	
	// passa envio em json e xml
	@GetMapping(produces = { org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			org.springframework.http.MediaType.APPLICATION_JSON_VALUE })
	public List<Estado> listar1() {

		return estadoRepository.Listar();
	}

	/*
	// envia apenas em json 
	@GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public List<Estado> listar2() {

		return estadoRepository.Listar();
	}
	*/
}
