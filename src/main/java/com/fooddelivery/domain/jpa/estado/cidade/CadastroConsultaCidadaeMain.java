package com.fooddelivery.domain.jpa.estado.cidade;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.fooddelivery.FoodDeliveryApplication;
import com.fooddelivery.domain.model.Cidade;
import com.fooddelivery.infrastructure.repository.CadastroCidadeImpl;

public class CadastroConsultaCidadaeMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(FoodDeliveryApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCidadeImpl cadastroCidade = applicationContext.getBean(CadastroCidadeImpl.class);
		
		Cidade x = cadastroCidade.buscar(1l);
		
		 System.out.println(x.getNome());
	}
}