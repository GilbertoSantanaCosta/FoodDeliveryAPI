package com.fooddelivery.domain.jpa.estado.cidade;




import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.fooddelivery.FoodDeliveryApplication;
import com.fooddelivery.infrastructure.repository.CadastroEstadoImpl;


public class DeleteEstadoMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(FoodDeliveryApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroEstadoImpl cadastroEstado = applicationContext.getBean(CadastroEstadoImpl.class);
		
		
	    cadastroEstado.remover(1l);
	    
		
		
	}
}
