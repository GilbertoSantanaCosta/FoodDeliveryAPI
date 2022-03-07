package com.fooddelivery.domain.jpa;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.fooddelivery.FoodDeliveryApplication;
import com.fooddelivery.domain.model.Cozinha;
import com.fooddelivery.infrastructure.repository.CadastroCozinhaImpl;

public class IncluirCozinhaMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(FoodDeliveryApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCozinhaImpl cadastroCozinha = applicationContext.getBean(CadastroCozinhaImpl.class);
		
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Brasileira");
		
		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("russa");
		
	    cozinha1 = cadastroCozinha.salvar(cozinha1);
	    cozinha2 = cadastroCozinha.salvar(cozinha2);
		
		System.out.println(cozinha1.getId() + " \n" + cozinha2.getId() );
	}
}
