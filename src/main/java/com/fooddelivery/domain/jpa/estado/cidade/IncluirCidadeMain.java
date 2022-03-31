package com.fooddelivery.domain.jpa.estado.cidade;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.fooddelivery.FoodDeliveryApplication;
import com.fooddelivery.domain.model.Cidade;
import com.fooddelivery.infrastructure.repository.CadastroCidadeImpl;

public class IncluirCidadeMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(FoodDeliveryApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCidadeImpl cadastroCidade = applicationContext.getBean(CadastroCidadeImpl.class);
		
		Cidade cidade1 = new Cidade();
		cidade1.setNome("osasco");
		
		Cidade cidade2 = new Cidade();
		cidade2.setNome("itapevi");
		
	    cidade1 = cadastroCidade.salvar(cidade1);
	    cidade2 = cadastroCidade.salvar(cidade2);
		
		System.out.println(cidade1.getId() + " \n" + cidade2.getId() );
	}
}
