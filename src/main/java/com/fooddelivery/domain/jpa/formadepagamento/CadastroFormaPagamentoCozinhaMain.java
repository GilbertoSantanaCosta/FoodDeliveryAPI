package com.fooddelivery.domain.jpa.formadepagamento;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.fooddelivery.FoodDeliveryApplication;
import com.fooddelivery.domain.model.Cozinha;
import com.fooddelivery.infrastructure.repository.CadastroCozinhaImpl;

public class CadastroFormaPagamentoCozinhaMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(FoodDeliveryApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCozinhaImpl cadastroCozinha = applicationContext.getBean(CadastroCozinhaImpl.class);
		
		Cozinha x = cadastroCozinha.buscar(1l);
		
		 System.out.println(x.getNome());
	}
}
