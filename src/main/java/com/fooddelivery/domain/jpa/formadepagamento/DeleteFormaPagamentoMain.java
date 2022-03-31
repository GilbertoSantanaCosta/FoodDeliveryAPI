package com.fooddelivery.domain.jpa.formadepagamento;




import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.fooddelivery.FoodDeliveryApplication;
import com.fooddelivery.infrastructure.repository.CadastroCozinhaImpl;


public class DeleteFormaPagamentoMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(FoodDeliveryApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCozinhaImpl cadastroCozinha = applicationContext.getBean(CadastroCozinhaImpl.class);
		
		
	    cadastroCozinha.remover(1l);
	    
		
		
	}
}
