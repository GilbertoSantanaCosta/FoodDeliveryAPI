package com.fooddelivery.domain.jpa.estado.cidade;




import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.fooddelivery.FoodDeliveryApplication;
import com.fooddelivery.infrastructure.repository.CadastroCidadeImpl;


public class DeleteCidadeMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(FoodDeliveryApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCidadeImpl cadastroCidade = applicationContext.getBean(CadastroCidadeImpl.class);
		
		
	    cadastroCidade.remover(1l);
	    
		
		
	}
}
